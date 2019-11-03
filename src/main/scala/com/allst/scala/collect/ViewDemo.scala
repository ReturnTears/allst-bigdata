package com.allst.scala.collect

/**
  * view
  * @author YiYa
  * @since 2019-11-03 下午 05:00
  */
object ViewDemo {
  def main(args: Array[String]): Unit = {
    // 不使用view模式
    val notUseView = (1 to 100).filter(eq)
    println(notUseView)

    // 使用view
    val useView = (1 to 100).view.filter(eq)
    println(useView)
    for (item <- useView) {
      println(item)
    }
  }
  // 对比当前数和它逆序后是否相等
  def eq(i: Int): Boolean = {
    i.toString.equals(i.toString.reverse)
  }
}
