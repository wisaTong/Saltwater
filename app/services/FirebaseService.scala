package services

import com.google.firebase.database.{DatabaseReference, FirebaseDatabase}
import scala.collection.JavaConverters._

object FirebaseService {
  val database: FirebaseDatabase = FirebaseDatabase.getInstance()

  def ref: DatabaseReference = database.getReference("chat/Room")

  def save(name: String) = {
    val data: Map[String, AnyRef] = Map("Create" -> List(name).asJava)
    ref.updateChildrenAsync(data.asJava)
  }

}
