package com.allst.scala.demo

import scala.io.Source

/**
  * Scala学习 -主构造器
  *
  * @author June
  *         2018/04/09
  */
class MissRight {
  // 在new的时候主构造器里的内容会被执行
  val name = "YY"
  println(name)
  def sayHi: Unit = {
    println("hi")
  }
  name.toLowerCase
  try {
    val contents = Source.fromFile("E:\\yinhai\\scala.txt").mkString
    println(contents)
  } catch {
    case e: Exception => e.printStackTrace()
  } finally {
    println("it`s done!")
  }
}

object MissRight {
  def main(args: Array[String]): Unit = {
    val mr = new MissRight
    mr.sayHi

    val arr = Array(1,2,3,4,5)

  }
}