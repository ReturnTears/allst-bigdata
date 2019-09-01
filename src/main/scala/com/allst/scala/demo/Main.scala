package com.allst.scala.demo

import StringUtils._

/**
  * @author JUNN
  * @since 2019-08-26 下午 10:42
  */
object Main {
  println("HAL".increment)

  def main(args: Array[String]): Unit = {
    val a = 0.3
    val b = 0.1 + 0.2
    val c = new Foo()
    val d = c.~=(a, b, 0.0001)
    println(d)
  }
}
