package myStateful

class BankAccount {
  private var _balance              = 0
  private var actions: List[Action] = Nil

  def deposit(amount: Int): Unit = synchronized {
    _balance += amount
    val deposit = Deposit(amount)
    ExternalSevice.save(deposit)
    actions ::= deposit
  }

  def withdraw(amount: Int): Unit = synchronized {
    _balance -= amount
    val withdrawal = Withdrawal(amount)
    ExternalSevice.save(withdrawal)
    actions ::= withdrawal
  }

  def balance: Int = synchronized {
    _balance
  }

  def get: (Int, List[Action]) = synchronized {
    (_balance, actions)
  }
}
