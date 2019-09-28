package com.allst.scala.demo

/**
  * Scala异常
  * @author YiYa
  * @since 2019-09-28 下午 10:15
  */
object ScalaException {
  def main(args: Array[String]): Unit = {
    f11()

    // 捕获异常
    /*try {
      var r = 10 / 0
    } catch {
      case ex: ArithmeticException => {
        println("捕获到除数为0的异常")
      }
      case e: Exception => println("捕获到异常")
    } finally {
      println("scala finally...")
    }
    println("ok. 继续执行...")*/
  }

  // 抛异常, 声明式异常
  @throws(classOf[NumberFormatException])
  def f11() {
    "abc".toInt
  }
}
