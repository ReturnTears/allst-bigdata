package com.allst.scala.demo

/**
  * Scala学习 - Scala对象一般指的object
  */
object SingletonDemo {
  def main(args: Array[String]): Unit = {
    // 单例模式
    val s = SingletonDemo
    Thread.sleep(2000)
    println(s)
    val a = SingletonDemo
    println(a)
  }
}

object HelloApply {
  def apply(): Unit = {
    println("apply invoked")
  }

  def apply(name: String): Unit = {
    println(name)
  }

//  def main(args: Array[String]): Unit = {
//    val h = HelloApply(name = "xXx")
//    println(h)
//
//    val ha = new HelloApply("AAA", "OOO")
//    println(ha)
//  }
}

//class HelloApply(val id: String) {
//  var name: String = _
//  def this(id: String, name: String) {
//    // 辅助构造器一定要先调用主构造器
//    this(id, name)
//  }
//}

/**
  * 应用程序对象，这样写可以不写main方法
  */
object AppDemo extends App {

  println("Hello")
}