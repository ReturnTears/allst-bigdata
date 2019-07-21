package com.allst.scala.guig.demo

/**
  * @author JUNN
  * @since 2019-07-21 下午 04:27
  */
object UnitDemo {
  def main(args: Array[String]): Unit = {
    val res = sayHello()
    println("res > " + res)
  }

  // Unit等价于Java中的void, 只有一个实例值()
  def sayHello(): Unit = {

  }
}
