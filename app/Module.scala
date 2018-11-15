import com.google.inject.AbstractModule
import services.FirebaseStartupService

class Module extends AbstractModule {
  override def configure() = {
    bind(classOf[FirebaseStartupService]).asEagerSingleton()
  }
}
