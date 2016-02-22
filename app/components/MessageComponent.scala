package components

import com.softwaremill.macwire.wire
import com.softwaremill.macwire.aop.Interceptor

import controllers.MessageController
import services.MessageService

trait MessageComponent {

  lazy val messageController = logEvents(wire[MessageController])
  lazy val messqgeService = logEvents(wire[MessageService])
  def logEvents: Interceptor

}
