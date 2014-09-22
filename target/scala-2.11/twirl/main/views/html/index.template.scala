
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](_display_(/*2.2*/main(null)/*2.12*/ {_display_(Seq[Any](format.raw/*2.14*/("""
    
    """),_display_(/*4.6*/if(flash.containsKey("error"))/*4.36*/ {_display_(Seq[Any](format.raw/*4.38*/("""
        
        """),format.raw/*6.9*/("""<div class="alert-message error">
            <p>
                <strong>Oops!</strong> """),_display_(/*8.41*/flash/*8.46*/.get("error")),format.raw/*8.59*/("""
            """),format.raw/*9.13*/("""</p>
        </div>
        
    """)))}),format.raw/*12.6*/("""
        
    """),format.raw/*14.5*/("""<div class="alert-message block-message info">
        <p>
            <strong>This is the Play 2.0 Websocket sample application!</strong> 
            To start, choose a username and sign in using the top right form.
        </p>
    </div>
    
""")))}))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Sep 21 15:37:27 CEST 2014
                  SOURCE: /Users/javiercalvo/Falcon/activator-1.2.10/Test/app/views/index.scala.html
                  HASH: ae54839f8c8c41d327e8069e22019d559fd06345
                  MATRIX: 798->2|816->12|855->14|891->25|929->55|968->57|1012->75|1128->165|1141->170|1174->183|1214->196|1278->230|1319->244
                  LINES: 29->2|29->2|29->2|31->4|31->4|31->4|33->6|35->8|35->8|35->8|36->9|39->12|41->14
                  -- GENERATED --
              */
          