package services

import com.google.firebase.database.{DatabaseReference, FirebaseDatabase}
import scala.collection.JavaConverters._

object FirebaseService {
  val database: FirebaseDatabase = FirebaseDatabase.getInstance()

  def ref: DatabaseReference = database.getReference("chat/SKE15")

  def save(name: String) = {
    val data: Map[String, AnyRef] = Map("title" -> name)
    ref.updateChildrenAsync(data.asJava)
  }

}
