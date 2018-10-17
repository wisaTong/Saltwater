import java.time.LocalTime
case class Messages(id:String,message:String,time: String = LocalTime.now.toString)
//def GetMessage():String={
//  return Messages.
//}