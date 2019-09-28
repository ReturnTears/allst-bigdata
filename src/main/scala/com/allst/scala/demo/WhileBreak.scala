package com.allst.scala.demo

import util.control.Breaks._
/**
  * @author JUNN
  * @since 2019-09-28 上午 11:23
  */
object WhileBreak {
  def main(args: Array[String]): Unit = {
    var n = 1
    breakable {
      while (n <= 20) {
        n += 1
        println("n = " + n)
        if (n == 18) {
          // 中断
          break()
        }
      }
    }
    println("ok~~~~")
  }
}
