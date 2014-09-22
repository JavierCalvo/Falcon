
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
object sendMessage extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>

<html>

	<head>
		<script src="https://code.jquery.com/jquery-1.9.1.js" type='text/javascript'>
			/* Adding a handler to the submit event */
			$("#form1").submit(function(event) """),format.raw/*8.39*/("""{"""),format.raw/*8.40*/("""

				"""),format.raw/*10.5*/("""var d = """),format.raw/*10.13*/("""{"""),format.raw/*10.14*/(""" """),format.raw/*10.15*/(""""message" : $('#message').val()"""),format.raw/*10.46*/("""}"""),format.raw/*10.47*/(""";

					$.ajax("""),format.raw/*12.13*/("""{"""),format.raw/*12.14*/("""
						"""),format.raw/*13.7*/("""//url: "http://localhost:9000/sendMessage",
						type :  "POST",
						url: "http://localhost:9000/sendMessage",
					    contentType: "application/json, charset=UTF-8",
					    dataType: "json",
					    data: JSON.stringify(d),
					        success: function(data)"""),format.raw/*19.37*/("""{"""),format.raw/*19.38*/("""
					            """),format.raw/*20.18*/("""console.log(data);
					        """),format.raw/*21.14*/("""}"""),format.raw/*21.15*/("""
					"""),format.raw/*22.6*/("""}"""),format.raw/*22.7*/(""");
			"""),format.raw/*23.4*/("""}"""),format.raw/*23.5*/(""");
			
		</script>
	</head>

	<body>
		<form id="form1" title="" method="post">
			<div>
				<label class="title">Enter your Message</label>
				<input type="text" id="message" name="message" >
			</div>

			<div>
				<input type="submit" id="submitButton"  name="submitButton" value="Send">
			</div>
		</form>
	</body>

</html>"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Sep 22 07:43:14 CEST 2014
                  SOURCE: /Users/javiercalvo/Falcon/activator-1.2.10/Test/app/views/sendMessage.scala.html
                  HASH: 14544e2a1ba849ed2498c2dcf6b1093388c999d5
                  MATRIX: 804->0|1028->197|1056->198|1089->204|1125->212|1154->213|1183->214|1242->245|1271->246|1314->261|1343->262|1377->269|1673->537|1702->538|1748->556|1808->588|1837->589|1870->595|1898->596|1931->602|1959->603
                  LINES: 29->1|36->8|36->8|38->10|38->10|38->10|38->10|38->10|38->10|40->12|40->12|41->13|47->19|47->19|48->20|49->21|49->21|50->22|50->22|51->23|51->23
                  -- GENERATED --
              */
          