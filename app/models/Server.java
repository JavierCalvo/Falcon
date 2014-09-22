package models;


import play.mvc.*;
import play.libs.*;
import play.libs.F.*;

import akka.util.*;
import akka.actor.*;
import akka.dispatch.*;
import static akka.pattern.Patterns.ask;

import com.fasterxml.jackson.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

import java.util.*;


import java.util.concurrent.TimeUnit;
import static java.util.concurrent.TimeUnit.SECONDS;
import scala.concurrent.duration.Duration;
import scala.concurrent.Await;
import play.libs.Json;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;
import com.typesafe.plugin.RedisPlugin;


public class Server extends UntypedActor {

    static ActorRef messageViewer = Akka.system().actorOf(Props.create(Server.class));

    private static final String CHANNEL = "messages";
    private static final String LOG = "logger";

    static{

		//subscribe to the message channel
		Akka.system().scheduler().scheduleOnce(
			Duration.create(10, TimeUnit.MILLISECONDS),
			new Runnable() {
				public void run() {
					Jedis j = play.Play.application().plugin(RedisPlugin.class).jedisPool().getResource();
					j.subscribe(new JedisListener(), Server.CHANNEL);
				}
			},
			Akka.system().dispatcher()
		);

    }

    // Users connected
    static ArrayList< WebSocket.Out<JsonNode>> members = new ArrayList< WebSocket.Out<JsonNode>>();

    public static void join(WebSocket.In<JsonNode> in, final WebSocket.Out<JsonNode> out) throws Exception{

        String result = (String)Await.result(ask(messageViewer,new Join(out), 3000), Duration.create(3, SECONDS));    
        if("OK".equals(result)) {
            // For each event received on the socket,
            in.onMessage(new Callback<JsonNode>() {
    
                public void invoke(JsonNode event) {
                	Talk talk = new Talk(event.get("text").asText());
                    
                    Jedis j = play.Play.application().plugin(RedisPlugin.class).jedisPool().getResource();
					try {
					//All messages are pushed through the pub/sub channel
						j.publish(Server.CHANNEL, Json.stringify(Json.toJson(talk)));
					} finally {
						play.Play.application().plugin(RedisPlugin.class).jedisPool().returnResource(j);
					}
					messageViewer.tell(talk,null);
                }
            });
    
            // When the socket is closed.
            in.onClose(new Callback0() {
                public void invoke() {
                    // Send a Quit message to the room.
                        messageViewer.tell(new Quit(out), null);
                }
            });

        } else {
            // Cannot connect, create a Json error.
            ObjectNode error = Json.newObject();
            error.put("error", result);
            // Send the error to the socket.
            out.write(error);
        }
    }

    public void onReceive(Object message) throws Exception {

        if(message instanceof Join) {
            // Received a Join message
            Join join = (Join)message;               
            members.add(join.channel);
            getSender().tell("OK", getSelf());
                
        } else if(message instanceof Quit) {
            Quit quit = (Quit)message;               
            members.remove(quit.channel);

        } else if(message instanceof Talk) {
            // Received a Talk message
            Talk talk = (Talk)message;
            notifyAll(talk.text);
        } else {
            unhandled(message);
        }
        
    }

    // Send a Json event to all members connected to this node
    public static void notifyAll(String text) {

    	ObjectNode message = Json.newObject();
        message.put("message", text); 

        for(WebSocket.Out<JsonNode> channel: members) {
            channel.write(message);
        }

    }

    // -- Messages
    public static class Join {

        final WebSocket.Out<JsonNode> channel;

        public Join(WebSocket.Out<JsonNode> channel) {
            this.channel = channel;
        }
        public String getType() {
			return "join";
		}
    }

    public static class Talk {

        final String text;

        public Talk(String text) {
            this.text = text;
        }
        public String getType() {
			return "talk";
		}
		public String getText() {
			return text;
		}
    }
    public static class Quit {

        final WebSocket.Out<JsonNode> channel;

        public Quit(WebSocket.Out<JsonNode> channel) {
            this.channel = channel;
        }

        public String getType() {
			return "quit";
		}
    }

    //New message Rest EndPoint
	public static void newMessage(String message){

		Talk talk = new Talk(message);
        //notifyAll(talk.text);

        Jedis j = play.Play.application().plugin(RedisPlugin.class).jedisPool().getResource();
		try {
			//All messages are pushed through the pub/sub channel
			j.publish(Server.CHANNEL, Json.stringify(Json.toJson(talk)));
			//and stored 
			j.sadd(Server.LOG, talk.text);
		} finally {
			play.Play.application().plugin(RedisPlugin.class).jedisPool().returnResource(j);
		}

        
		return;
	}

	//Return the list of messages 
	public static ObjectNode getMessages(){
		ObjectNode log = Json.newObject();
		ArrayNode messagesList = JsonNodeFactory.instance.arrayNode(); 
		int i=0;

		Jedis j = play.Play.application().plugin(RedisPlugin.class).jedisPool().getResource();
		try {
			//get the log of the messages
			for(String m: j.smembers(Server.LOG)) {
				ObjectNode message = Json.newObject();
				message.put("message", m);
				messagesList.add(message);
			}
			
		} finally {
			play.Play.application().plugin(RedisPlugin.class).jedisPool().returnResource(j);
		}
		log.put("log", messagesList);
		return log;
	}

	public static void remoteMessage(Object message) {
		messageViewer.tell(message, null);
	}

	public static class JedisListener extends JedisPubSub {
	
		@Override
		public void onMessage(String channel, String messageBody) {
			JsonNode parsedMessage = Json.parse(messageBody);
			Object message = null;
			String messageType = parsedMessage.get("type").asText();

			if("talk".equals(messageType)) {
				message = new Talk(parsedMessage.get("text").asText());
			}

			Server.remoteMessage(message);

		}
		
		@Override
		public void onPMessage(String arg0, String arg1, String arg2) {
		}
		@Override
		public void onPSubscribe(String arg0, int arg1) {
		}
		@Override
		public void onPUnsubscribe(String arg0, int arg1) {
		}
		@Override
		public void onSubscribe(String arg0, int arg1) {
		}
		@Override
		public void onUnsubscribe(String arg0, int arg1) {
		}
	}
}
