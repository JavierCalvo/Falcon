// @SOURCE:/Users/javiercalvo/Falcon/activator-1.2.10/Test/conf/routes
// @HASH:90aa511d0ca372ab654007f81002e390a333ac72
// @DATE:Mon Sep 22 06:50:44 CEST 2014


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
controllers.Application.index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
        

// @LINE:7
private[this] lazy val controllers_Application_addMessage1_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sendMessage"))))
private[this] lazy val controllers_Application_addMessage1_invoker = createInvoker(
controllers.Application.addMessage(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "addMessage", Nil,"POST", """""", Routes.prefix + """sendMessage"""))
        

// @LINE:8
private[this] lazy val controllers_Application_sendMessage2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("sendMessage"))))
private[this] lazy val controllers_Application_sendMessage2_invoker = createInvoker(
controllers.Application.sendMessage(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "sendMessage", Nil,"GET", """""", Routes.prefix + """sendMessage"""))
        

// @LINE:9
private[this] lazy val controllers_Application_getMessages3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("messages"))))
private[this] lazy val controllers_Application_getMessages3_invoker = createInvoker(
controllers.Application.getMessages(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getMessages", Nil,"GET", """""", Routes.prefix + """messages"""))
        

// @LINE:10
private[this] lazy val controllers_Application_messagesRoom4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("timeline"))))
private[this] lazy val controllers_Application_messagesRoom4_invoker = createInvoker(
controllers.Application.messagesRoom(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "messagesRoom", Nil,"GET", """""", Routes.prefix + """timeline"""))
        

// @LINE:11
private[this] lazy val controllers_Application_view5_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("timeline/view"))))
private[this] lazy val controllers_Application_view5_invoker = createInvoker(
controllers.Application.view(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "view", Nil,"GET", """""", Routes.prefix + """timeline/view"""))
        

// @LINE:15
private[this] lazy val controllers_Assets_at6_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at6_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sendMessage""","""controllers.Application.addMessage()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """sendMessage""","""controllers.Application.sendMessage()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """messages""","""controllers.Application.getMessages()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """timeline""","""controllers.Application.messagesRoom()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """timeline/view""","""controllers.Application.view()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(controllers.Application.index())
   }
}
        

// @LINE:7
case controllers_Application_addMessage1_route(params) => {
   call { 
        controllers_Application_addMessage1_invoker.call(controllers.Application.addMessage())
   }
}
        

// @LINE:8
case controllers_Application_sendMessage2_route(params) => {
   call { 
        controllers_Application_sendMessage2_invoker.call(controllers.Application.sendMessage())
   }
}
        

// @LINE:9
case controllers_Application_getMessages3_route(params) => {
   call { 
        controllers_Application_getMessages3_invoker.call(controllers.Application.getMessages())
   }
}
        

// @LINE:10
case controllers_Application_messagesRoom4_route(params) => {
   call { 
        controllers_Application_messagesRoom4_invoker.call(controllers.Application.messagesRoom())
   }
}
        

// @LINE:11
case controllers_Application_view5_route(params) => {
   call { 
        controllers_Application_view5_invoker.call(controllers.Application.view())
   }
}
        

// @LINE:15
case controllers_Assets_at6_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at6_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     