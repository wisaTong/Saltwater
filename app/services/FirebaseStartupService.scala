package services

import java.io.InputStream

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.{FirebaseApp, FirebaseOptions}
import javax.inject.Singleton

@Singleton
class FirebaseStartupService {

  def start() = {
    val serviceAccount: InputStream = getClass.getResourceAsStream("/salt-service.json")
    val option = new FirebaseOptions.Builder()
      .setCredentials(GoogleCredentials.fromStream(serviceAccount))
      .setDatabaseUrl("https://isp-chat-app.firebaseio.com")
      .build()
    FirebaseApp.initializeApp(option)
    FirebaseService.initChatRooms()
  }

  if (FirebaseApp.getApps.isEmpty) start()
}
