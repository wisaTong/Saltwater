package services

import com.google.firebase.database._
import play.api.Logger
import actor.ChatSystem

import scala.collection.JavaConverters._

object FirebaseService {
  val database: FirebaseDatabase = FirebaseDatabase.getInstance()

  def ref: DatabaseReference = database.getReference("chat")

  def save(name: String) = {
    val data: Map[String, AnyRef] = Map("Create" -> List(name).asJava)
    ref.updateChildrenAsync(data.asJava)
  }

  def retrieving() = {
    val ref2 = ref.child("Room").child("Create")
    ref2.addListenerForSingleValueEvent(new ValueEventListener {
      override def onDataChange(snapshot: DataSnapshot): Unit = {
        snapshot.getChildren.forEach(data => {
          Logger.info(data.getValue(classOf[String]))
          ChatSystem.createRoom(data.getValue(classOf[String]))
        })
      }

      override def onCancelled(error: DatabaseError): Unit = {}
    })
  }

}
