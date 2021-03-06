import play.api.ApplicationLoader
import play.api.ApplicationLoader.Context
import play.api.{Logger, BuiltInComponents, BuiltInComponentsFromContext}
import play.api.routing.Router
import router.Routes
import com.softwaremill.macwire._

import components.MessageComponent

class ApplicationLoaderImpl extends ApplicationLoader {

  def load(context: Context) = {

    // make sure logging is configured
    Logger.configure(context.environment)

    new AppComponents(context).application
  }

}

class AppComponents(context: Context) extends BuiltInComponentsFromContext(context) with MessageComponent {

  lazy val router: Router = {
    lazy val prefix = "/"
    wire[Routes]
  }

}
