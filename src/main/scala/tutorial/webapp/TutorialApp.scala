package tutorial.webapp

import org.scalajs.dom
import dom.document
import scala.scalajs.js.JSApp
import org.scalajs.jquery.jQuery
import scala.concurrent.ExecutionContext.Implicits.global
import dom.ext.Ajax

object TutorialApp extends JSApp {
  def main(): Unit = {
    Ajax.get("/index.json").foreach { xhr =>
      // val json = read[Map[String,String]](xhr.responseText)
      val header1Node = document.createElement("h1")
      val textNode = document.createTextNode(xhr.responseText)
      header1Node.appendChild(textNode)
      document.body.appendChild(header1Node)
    }
  }
}
