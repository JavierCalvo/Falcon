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

import java.util.*;


import static java.util.concurrent.TimeUnit.SECONDS;
import scala.concurrent.duration.Duration;
import scala.concurrent.Await;
import play.libs.Json;


public class Server extends UntypedActor {

	// Default room.
    static ActorRef messageViewer = Akka.system().actorOf(Props.create(Server.class));
    private static final String CHANNEL = "messages";
    private static final String MEMBERS = "members";


    public static void join(WebSocket.In<JsonNode> in, final WebSocket.Out<JsonNode> out) throws Exception{
        // Join the default room. Timeout should be longer than the Redis connect timeout (2 seconds)

        String result = (String)Await.result(ask(messageViewer,new Join(out), 1000), Duration.create(1, SECONDS));    
        if("OK".equals(result)) {
            // For each event received on the socket,
            in.onMessage(new Callback<JsonNode>() {
    
                public void invoke(JsonNode event) {
                    messageViewer.tell(new Talk(event.get("text").asText()),null);
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

    public static void remoteMessage(Object message) {
        messageViewer.tell(message, null);
    }

    // Users connected to this node
    ArrayList< WebSocket.Out<JsonNode>> members = new ArrayList< WebSocket.Out<JsonNode>>();
    
    public void onReceive(Object message) throws Exception {
      
            if(message instanceof Join) {
                // Received a Join message
                Join join = (Join)message;               
                members.add(join.channel);
                getSender().tell("OK", getSelf());
                
            } else if(message instanceof Quit) {
                Quit quit = (Quit)message;               
                members.remove(quit.channel);
                
                //notifyAll("quit", quit.channel, "has leaved the room");

            } else if(message instanceof Talk) {
            // Received a Talk message
                Talk talk = (Talk)message;
                notifyAll("talk", talk.text);
            } else {
                unhandled(message);
            }
        
    }

    // Send a Json event to all members connected to this node
    public void notifyAll(String kind, String text) {
        for(WebSocket.Out<JsonNode> channel: members) {
            ObjectNode event = Json.newObject();
            event.put("kind", kind);
            event.put("message", text);
            /*ArrayNode m = event.putArray("members");
            for(String u: members.keySet()) {
                m.add(u);
            }*/
            
            channel.write(event);
        }
    }

    // -- Messages
    public static class Join {
        final WebSocket.Out<JsonNode> channel;
        public Join(WebSocket.Out<JsonNode> channel) {
            this.channel = channel;
        }
    }

    public static class Talk {
        final String text;
        public Talk(String text) {
            this.text = text;
        }
    }
    public static class Quit {
        final WebSocket.Out<JsonNode> channel;
        public Quit(WebSocket.Out<JsonNode> channel) {
            this.channel = channel;
        }
    }

	public static void newMessage(String message){
/*
		Jedis j = play.Play.application().plugin(RedisPlugin.class).jedisPool().getResource();
		try {
			//All messages are pushed through the pub/sub channel
			j.publish(Server.CHANNEL, message);
		} finally {
			play.Play.application().plugin(RedisPlugin.class).jedisPool().returnResource(j);
		}
*/
		return;


		//notify all (webSockets)
		//save on Redis
	}

	public static void getMessages(){
		/*Jedis j = play.Play.application().plugin(RedisPlugin.class).jedisPool().getResource();
		try {
			for(String m: j.smembers(Server.CHANNEL)){
				System.out.println(m);
			}
		} finally {
			play.Play.application().plugin(RedisPlugin.class).jedisPool().returnResource(j);
		}*/

		return;
	}
}
