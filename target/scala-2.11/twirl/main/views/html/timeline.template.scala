
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
object timeline extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](_display_(/*1.2*/main("Welcome to Play 2.0")/*1.29*/ {_display_(Seq[Any](format.raw/*1.31*/("""
    
    """),format.raw/*3.5*/("""<div class="page-header">
        <h1>Welcome to the Message Viewer </h1>
    </div>
    
    <div id="onChat" class="row">
        <div class="span10" id="main">
            <div id="messages">
            </div>
            <!--<textarea id="talk"></textarea>-->
        </div>
    </div>
    
    <script type="text/javascript" charset="utf-8">
    
        $(function() """),format.raw/*17.22*/("""{"""),format.raw/*17.23*/("""
            """),format.raw/*18.13*/("""var WS = window['MozWebSocket'] ? MozWebSocket : WebSocket
	        var chatSocket = new WS(""""),_display_(/*19.36*/routes/*19.42*/.Application.view().webSocketURL(request)),format.raw/*19.83*/("""")
            
            var sendMessage = function() """),format.raw/*21.42*/("""{"""),format.raw/*21.43*/("""
                """),format.raw/*22.17*/("""chatSocket.send(JSON.stringify(
                    """),format.raw/*23.21*/("""{"""),format.raw/*23.22*/("""text: $("#talk").val()"""),format.raw/*23.44*/("""}"""),format.raw/*23.45*/("""
                """),format.raw/*24.17*/("""))
                $("#talk").val('')
            """),format.raw/*26.13*/("""}"""),format.raw/*26.14*/("""
            
            """),format.raw/*28.13*/("""var receiveEvent = function(event) """),format.raw/*28.48*/("""{"""),format.raw/*28.49*/("""
                """),format.raw/*29.17*/("""var data = JSON.parse(event.data)
                
                // Handle errors
                if(data.error) """),format.raw/*32.32*/("""{"""),format.raw/*32.33*/("""
                    """),format.raw/*33.21*/("""chatSocket.close()
                    $("#onError span").text(data.error)
                    $("#onError").show()
                    return
                """),format.raw/*37.17*/("""}"""),format.raw/*37.18*/(""" """),format.raw/*37.19*/("""else """),format.raw/*37.24*/("""{"""),format.raw/*37.25*/("""
                    """),format.raw/*38.21*/("""$("#onChat").show()
                """),format.raw/*39.17*/("""}"""),format.raw/*39.18*/("""
                
                """),format.raw/*41.17*/("""// Create the message element
                var el = $('<div class="message"><p></p></div>')
                $("p", el).text(data.message)
                $(el).addClass(data.kind)
                $('#messages').append(el)
                
            """),format.raw/*47.13*/("""}"""),format.raw/*47.14*/("""
            
            """),format.raw/*49.13*/("""var handleReturnKey = function(e) """),format.raw/*49.47*/("""{"""),format.raw/*49.48*/("""
                """),format.raw/*50.17*/("""if(e.charCode == 13 || e.keyCode == 13) """),format.raw/*50.57*/("""{"""),format.raw/*50.58*/("""
                    """),format.raw/*51.21*/("""e.preventDefault()
                    sendMessage()
                """),format.raw/*53.17*/("""}"""),format.raw/*53.18*/(""" 
            """),format.raw/*54.13*/("""}"""),format.raw/*54.14*/("""
            
            """),format.raw/*56.13*/("""$("#talk").keypress(handleReturnKey)  
            
            chatSocket.onmessage = receiveEvent
            
        """),format.raw/*60.9*/("""}"""),format.raw/*60.10*/(""")
    
    </script>
    
""")))}))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Sep 21 18:45:04 CEST 2014
                  SOURCE: /Users/javiercalvo/Falcon/activator-1.2.10/Test/app/views/timeline.scala.html
                  HASH: 18106fa82e0a56143b62a5d9ae11ea78af3dd66f
                  MATRIX: 801->1|836->28|875->30|911->40|1313->414|1342->415|1383->428|1504->522|1519->528|1581->569|1666->626|1695->627|1740->644|1820->696|1849->697|1899->719|1928->720|1973->737|2051->787|2080->788|2134->814|2197->849|2226->850|2271->867|2414->982|2443->983|2492->1004|2679->1163|2708->1164|2737->1165|2770->1170|2799->1171|2848->1192|2912->1228|2941->1229|3003->1263|3285->1517|3314->1518|3368->1544|3430->1578|3459->1579|3504->1596|3572->1636|3601->1637|3650->1658|3747->1727|3776->1728|3818->1742|3847->1743|3901->1769|4049->1890|4078->1891
                  LINES: 29->1|29->1|29->1|31->3|45->17|45->17|46->18|47->19|47->19|47->19|49->21|49->21|50->22|51->23|51->23|51->23|51->23|52->24|54->26|54->26|56->28|56->28|56->28|57->29|60->32|60->32|61->33|65->37|65->37|65->37|65->37|65->37|66->38|67->39|67->39|69->41|75->47|75->47|77->49|77->49|77->49|78->50|78->50|78->50|79->51|81->53|81->53|82->54|82->54|84->56|88->60|88->60
                  -- GENERATED --
              */
          