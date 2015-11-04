package tutorial.webapp

import org.scalajs.dom.document
import org.scalajs.dom.ext.Ajax
import scala.scalajs.js.JSON
import scala.concurrent.ExecutionContext.Implicits.global
import scala.scalajs.js.JSApp

object TutorialApp extends JSApp {
  def main(): Unit = {
    Ajax.get("index.json").foreach { xhr =>
      val json = JSON.parse(xhr.responseText)
      val h1 = json.selectDynamic("name").toString

      val header1Node = document.createElement("h1")
      val textNode = document.createTextNode(h1)
      header1Node.appendChild(textNode)
      document.body.appendChild(header1Node)
    }
  }
}
