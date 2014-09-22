// @SOURCE:/Users/javiercalvo/Falcon/activator-1.2.10/Test/conf/routes
// @HASH:90aa511d0ca372ab654007f81002e390a333ac72
// @DATE:Mon Sep 22 06:50:44 CEST 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:15
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:15
class ReverseAssets {


// @LINE:15
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:8
def sendMessage(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "sendMessage")
}
                        

// @LINE:9
def getMessages(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "messages")
}
                        

// @LINE:7
def addMessage(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "sendMessage")
}
                        

// @LINE:10
def messagesRoom(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "timeline")
}
                        

// @LINE:6
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

// @LINE:11
def view(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "timeline/view")
}
                        

}
                          
}
                  


// @LINE:15
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:15
class ReverseAssets {


// @LINE:15
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:8
def sendMessage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.sendMessage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sendMessage"})
      }
   """
)
                        

// @LINE:9
def getMessages : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getMessages",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "messages"})
      }
   """
)
                        

// @LINE:7
def addMessage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.addMessage",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sendMessage"})
      }
   """
)
                        

// @LINE:10
def messagesRoom : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.messagesRoom",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "timeline"})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:11
def view : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.view",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "timeline/view"})
      }
   """
)
                        

}
              
}
        


// @LINE:15
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:15
class ReverseAssets {


// @LINE:15
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:8
def sendMessage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.sendMessage(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "sendMessage", Seq(), "GET", """""", _prefix + """sendMessage""")
)
                      

// @LINE:9
def getMessages(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getMessages(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getMessages", Seq(), "GET", """""", _prefix + """messages""")
)
                      

// @LINE:7
def addMessage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.addMessage(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "addMessage", Seq(), "POST", """""", _prefix + """sendMessage""")
)
                      

// @LINE:10
def messagesRoom(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.messagesRoom(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "messagesRoom", Seq(), "GET", """""", _prefix + """timeline""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:11
def view(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.view(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "view", Seq(), "GET", """""", _prefix + """timeline/view""")
)
                      

}
                          
}
        
    