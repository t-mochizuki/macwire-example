import play.api.ApplicationLoader
import play.api.ApplicationLoader.Context
import play.api.{Logger, BuiltInComponents, BuiltInComponentsFromContext}
import play.api.routing.Router
import router.Routes
import com.softwaremill.macwire._
import com.softwaremill.macwire.aop.ProxyingInterceptor

import components.MessageComponent

class ApplicationLoaderImpl extends ApplicationLoader {

  def load(context: Context) = {

    // make sure logging is configured
    Logger.configure(context.environment)

    new AppComponents(context).application
  }

}

class AppComponents(context: Context) extends BuiltInComponentsFromContext(context) with MessageComponent {

  lazy val logEvents = ProxyingInterceptor { ctx =>
    println("Calling method: " + ctx.method.getName())
    ctx.proceed()
  }

  lazy val router: Router = {
    lazy val prefix = "/"
    wire[Routes]
  }

}
