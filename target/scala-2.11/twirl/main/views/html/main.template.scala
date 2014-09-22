
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
object main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(connected: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.36*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html>
    <head>
        <title>Websocket Message Room</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(/*8.54*/routes/*8.60*/.Assets.at("stylesheets/bootstrap.css")),format.raw/*8.99*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(/*9.54*/routes/*9.60*/.Assets.at("stylesheets/main.css")),format.raw/*9.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*10.59*/routes/*10.65*/.Assets.at("images/favicon.png")),format.raw/*10.97*/("""">
        <script src=""""),_display_(/*11.23*/routes/*11.29*/.Assets.at("javascripts/jquery-1.7.1.min.js")),format.raw/*11.74*/("""" type="text/javascript"></script>
    </head>
    <body>
        <div class="topbar">
            <div class="fill">
                <div class="container">
                    <a class="brand" href=""""),_display_(/*17.45*/routes/*17.51*/.Application.index()),format.raw/*17.71*/("""">Websocket Message Room</a>
                    
                   <!-- """),_display_(/*19.26*/if(connected != null)/*19.47*/ {_display_(Seq[Any](format.raw/*19.49*/("""
                        """),format.raw/*20.25*/("""<p class="pull-right">
                            Logged in as """),_display_(/*21.43*/connected),format.raw/*21.52*/(""" """),format.raw/*21.53*/("""‚Äî
                            <a href=""""),_display_(/*22.39*/routes/*22.45*/.Application.index()),format.raw/*22.65*/("""">Disconnect</a>
                        </p>
                    """)))}/*24.23*/else/*24.28*/{_display_(Seq[Any](format.raw/*24.29*/("""
                        """),format.raw/*25.25*/("""<form action=""""),_display_(/*25.40*/routes/*25.46*/.Application.messagesRoom()),format.raw/*25.73*/("""" class="pull-right">
                            <input id="username" name="username" class="input-small" type="text" placeholder="Username">
                            <button class="btn" type="submit">Sign in</button>
                        </form>
                    """)))}),format.raw/*29.22*/(""" """),format.raw/*29.23*/("""-->
                    
                </div>
            </div>
        </div>

        <div class="container">

            <div class="content">
                """),_display_(/*38.18*/content),format.raw/*38.25*/("""
            """),format.raw/*39.13*/("""</div>

            <footer>
                <p>
                    <a href="http://www.playframework.org">www.playframework.org</a>
                </p>
            </footer>

        </div>
        
    </body>
    </body>
</html>
"""))}
  }

  def render(connected:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(connected)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (connected) => (content) => apply(connected)(content)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Sep 21 18:45:04 CEST 2014
                  SOURCE: /Users/javiercalvo/Falcon/activator-1.2.10/Test/app/views/main.scala.html
                  HASH: 5e23569804916828031d5f9c263d6ef7740eb8f2
                  MATRIX: 727->1|849->35|877->37|1037->171|1051->177|1110->216|1192->272|1206->278|1260->312|1348->373|1363->379|1416->411|1468->436|1483->442|1549->487|1778->689|1793->695|1834->715|1936->790|1966->811|2006->813|2059->838|2151->903|2181->912|2210->913|2279->955|2294->961|2335->981|2421->1049|2434->1054|2473->1055|2526->1080|2568->1095|2583->1101|2631->1128|2937->1403|2966->1404|3160->1571|3188->1578|3229->1591
                  LINES: 26->1|29->1|31->3|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|45->17|45->17|45->17|47->19|47->19|47->19|48->20|49->21|49->21|49->21|50->22|50->22|50->22|52->24|52->24|52->24|53->25|53->25|53->25|53->25|57->29|57->29|66->38|66->38|67->39
                  -- GENERATED --
              */
          