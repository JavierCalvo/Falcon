package controllers;

import play.*;
import play.mvc.*;
import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.BodyParser;

import views.html.*;
import models.Server;

import scala.App;
import play.libs.Json;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;


public class Application extends Controller {

    public static Result index() {
        return ok(index.render());
    }
    
    //Json received at the Endpoint
    @BodyParser.Of(BodyParser.Json.class)
    public static Result addMessage() {
      JsonNode json = request().body().asJson();
      String message = json.findPath("message").textValue();
      //pass the message to the server
      Server.newMessage(message);
      return ok();
    }
    
    //returns a json with all messages
    public static Result getMessages(){
      return ok(Server.getMessages());
    }
    
    public static Result messagesRoom() {
      return ok(timeline.render());
    }

    public static Result sendMessage() {
      return ok(sendMessage.render());
    }

    public static WebSocket<JsonNode> view() {
      return new WebSocket<JsonNode>() {
        // Called when the Websocket Handshake is done.
        public void onReady(WebSocket.In<JsonNode> in, WebSocket.Out<JsonNode> out){
          // Join the server.
          try {
            Server.join(in, out);
          } catch (Exception ex) {
            ex.printStackTrace();
          }
        }
      };
    }
}
