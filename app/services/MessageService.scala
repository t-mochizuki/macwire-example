package services

import models.MessageDao

class MessageService(dao: MessageDao) {
  def index() = dao.findList()
}
