package com.allst.scala.demo

import scala.io.StdIn

/**
  * 接收键盘输入
  *
  * @author JUNN
  * @since 2019-09-10 下午 11:29
  */
object InputParam {
  def main(args: Array[String]): Unit = {
    println("请输入姓名:")
    val name = StdIn.readLine()
    println("请输入姓名:")
    val age = StdIn.readLine()
    println("请输入姓名:")
    val sal = StdIn.readLine()
  }
}
