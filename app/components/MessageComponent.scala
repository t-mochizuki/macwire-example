package components

import com.softwaremill.macwire.wire

import controllers.MessageController
import services.MessageService

trait MessageComponent {

  lazy val messageController = wire[MessageController]
  lazy val messqgeService = wire[MessageService]

}
