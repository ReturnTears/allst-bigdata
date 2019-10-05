package com.allst.scala.demo

/**
  * 面向对象编程案例
  * @author YiYa
  * @since 2019-10-06 上午 12:33
  */
object BankDemo {

  def main(args: Array[String]): Unit = {
    val acc = new Account("yh007", 9999.07, "123456")
    acc.query("123456")
    acc.withDraw("123456", 1000)
    acc.query("123456")
  }

}

/**
  * 账户类
  * 主构造器参数
  * @param inAcc
  *              账户
  * @param inBal
  *              余额
  * @param inPwd
  *              密码
  *
  */
class Account(inAcc: String, inBal: Double, inPwd: String) {
  val accountNo = inAcc
  var balance = inBal
  var pwd = inPwd

  /**
    * 查询
    * @param pwd
    *            密码
    */
  def query(pwd: String):Unit = {
    if (!this.pwd.equals(pwd)) {
      println("密码错误...")
      return
    }

    printf("账号为%s 的当前余额为%f \n", this.accountNo, this.balance)
  }

  def withDraw(pwd: String, money: Double): Any = {
    if (!this.pwd.equals(pwd)) {
      println("密码错误")
      return
    }
    if (this.balance < money) {
      println("余额不足")
      return
    }
    this.balance -= money
    this.balance
  }
}
