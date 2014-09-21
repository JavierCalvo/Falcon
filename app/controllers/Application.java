package controllers;

import play.*;
import play.mvc.*;
import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.BodyParser;

import views.html.*;
import models.Server;

import models.ChatRoom;

import scala.App;


public class Application extends Controller {

    public static Result index() {
        return ok(index.render());
    }
    
    @BodyParser.Of(BodyParser.Json.class)
    public static Result addMessage() {
      JsonNode json = request().body().asJson();
      String message = json.findPath("message").textValue();
      Server.newMessage(message);
      if(message == null) {
        return badRequest("Missing parameter [message]");
      } else {
        return ok("Message > " + message);
      }
      
    }
    
    //returns a json with all messages
    public static Result getMessages(){
      Server.getMessages();
      //return ok(Server.getMessages());
      return ok(index.render());

    }
    
    public static Result messagesRoom() {
      return ok(timeline.render());
    }
    
    /**
  * Handle the chat websocket.
  */
    public static WebSocket<JsonNode> view() {
      return new WebSocket<JsonNode>() {
        // Called when the Websocket Handshake is done.
        public void onReady(WebSocket.In<JsonNode> in, WebSocket.Out<JsonNode> out){
          // Join the chat room.
          try {
            Server.join(in, out);
          } catch (Exception ex) {
            ex.printStackTrace();
          }
        }
      };
    }
}
