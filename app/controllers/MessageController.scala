package controllers

import play.api._
import play.api.mvc._

import services.MessageService

class MessageController(service: MessageService) extends Controller {

  def index = Action {
    Ok(service.index)
  }

}
