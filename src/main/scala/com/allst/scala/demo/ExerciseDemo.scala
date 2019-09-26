package com.allst.scala.demo

import scala.io.StdIn

/**
  * 嵌套分支
  * if分支
 *
  * @author JUNN
  * @since 2019-09-26 下午 10:10
  */
object ExerciseDemo {
  def main(args: Array[String]): Unit = {
    println("输入运动员的成绩")
    val speed = StdIn.readDouble()
    if (speed <= 8) {
      println("请输入性别:")
      val gender = StdIn.readChar()
      if (gender == '男') {
        println("进入男子组")
      } else {
        println("进入女子组")
      }
    } else {
      println("你被淘汰了")
    }
  }
}
