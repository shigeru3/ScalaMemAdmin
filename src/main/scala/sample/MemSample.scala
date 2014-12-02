package sample

import shade.memcached._
import scala.concurrent.ExecutionContext.Implicits.{ global => ec }

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.beans.property.StringProperty
import scalafx.collections.ObservableBuffer
import scalafx.scene.Scene
import scalafx.scene.control.{TableColumn, TableView}
import scalafx.scene.layout.{Priority, VBox}
import scalafx.scene.paint.Color

/**
 * Created by hiroyuki_ikawa on 2014/12/01.
 */

object MemSample extends JFXApp{
  val memcached = Memcached(Configuration("127.0.0.1:11211"), ec)
  val keyColumn = new TableColumn[Record, String]("key") {
    cellValueFactory = f => new StringProperty(f.value, "key", f.value.key)
  }
  val valueColumn = new TableColumn[Record, String]("value") {
    cellValueFactory = f => new StringProperty(f.value, "value", f.value.value)
  }
  stage = new PrimaryStage {
    title = "ScalaMemAdmin"
    scene = new Scene {
      fill = Color.LightBlue
      root = new VBox {
        hgrow = Priority.Always
        content = new TableView[Record] {
          vgrow = Priority.Always
          columns ++= Seq(keyColumn, valueColumn)
          items = ObservableBuffer(
            Record("key", "value"),
            Record("key2", "value")
          )
        }
      }
    }
  }
}

case class Record(key: String, value: String)