package services

import com.google.firebase.database._
import play.api.Logger
import actor.ChatSystem

import scala.collection.JavaConverters._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object FirebaseService {
  val database: FirebaseDatabase = FirebaseDatabase.getInstance()

  def ref: DatabaseReference = database.getReference("chat")

  def save(name: String): Unit = {
    ref.child("Room").child("Create")
      .push().setValueAsync(name)
  }

  def initChatRooms(): Unit = {
    val roomRef = ref.child("Room").child("Create")
    roomRef.addListenerForSingleValueEvent(new ValueEventListener {
      override def onDataChange(snapshot: DataSnapshot): Unit =
        snapshot.getChildren.forEach(data => createRoomFromSnapshot(data))

      override def onCancelled(error: DatabaseError): Unit =
        Logger.error(s"Init chat rooms failed: ${error.getMessage}")
    })
  }

  def deleteRoom(name: String): Unit = {
    val roomRef = ref.child("Room").child("Create")
    roomRef.addListenerForSingleValueEvent(new ValueEventListener {
      override def onDataChange(snapshot: DataSnapshot): Unit =
        snapshot.getChildren.asScala
          .filter(_.getValue(classOf[String]) == name)
          .foreach(data => data.getRef.removeValueAsync())

      override def onCancelled(error: DatabaseError): Unit =
        Logger.error(s"deletion failed: ${error.getMessage}")
    })
  }

  private def createRoomFromSnapshot(snapshot: DataSnapshot): Unit = {
    val chatName = snapshot.getValue(classOf[String])
    Logger.info(s"$chatName created")
    Future(ChatSystem.createRoom(chatName))
  }
}
