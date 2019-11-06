package com.allst.scala.demo

/**
  * @author YiYa
  * @since 2019-11-06 下午 11:29
  */
object OperDemo {

  def main(args: Array[String]): Unit = {
    val a = 6
    val b = 10
    val c = a + b
    val d = a .+ (b)
    println(d)

    // 中置操作符
    val monkey = new Monkey
    monkey + 10
    monkey .+(10)
    println(monkey.money)

    // 后置操作符
    monkey.++
    println(monkey.money)

    !monkey
    println(monkey.money)
  }

}
class Monkey {
  var money: Int = 0

  def +(n: Int): Unit = {
    this.money += n
  }

  def ++(): Unit = {
    this.money += 1
  }

  def unary_!(): Unit = {
    this.money = -this.money
  }
}