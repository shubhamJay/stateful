package myStateful

object ExternalSevice {

  var actions = List.empty[Action]

  def save(action: Action): Unit = {
    Thread.sleep(1000)
    actions ::= action
  }
}
