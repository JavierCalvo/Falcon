package controllers;

import play.*;
import play.mvc.*;
import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.BodyParser;

import views.html.*;


public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Testing"));
    }
    
    @BodyParser.Of(BodyParser.Json.class)
    public static Result addMessage() {
      JsonNode json = request().body().asJson();
      String message = json.findPath("message").textValue();
      if(message == null) {
        return badRequest("Missing parameter [message]");
      } else {
        return ok("Message > " + message);
      }
      //store the messages in redis
    }
    
    //returns a json with all messages
    public static Result getMessages(){
      //Server.getMessages();
      //return ok(Server.getMessages());
      return ok(index.render("Testing"));

    }
    
   /*public static WebSocket<JsonNode> messagesRoom() {
    return ok(index.render("Testing"));
   }
        /*return new WebSocket<JsonNode>() {
            // Called when the Websocket Handshake is done.
            public void onReady(WebSocket.In<JsonNode> in, WebSocket.Out<JsonNode> out){
            try {
                Server.join(in, out);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
    }*/


}
