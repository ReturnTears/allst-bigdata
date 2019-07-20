package com.allst.scala.guig

/**
  * Hello Scala
  *
  * 1 - object 表示伴生对象们这里我们可以简单的理解就是一个对象
  * 2 - HelloScala就是对象名字， 他底层真正对应的类名是HelloScala$
  *     对象是HelloScala$类型的一个静态对象MODULE$
  * 3 - 当我们编写一个object HelloScala底层会生成两个.class文件, 分别为HelloScala.class和HelloScala$.class
  * 4 - scala运行时流程:
  *     4.1 - 先从HelloScala的main开始执行
  *     4.2 - main方法中会调用HelloScala$类的方法 HelloScala$.MODULE$.main
  *     4.3 -
  * 5 - def 表示是一个方法, 这是一个关键字
  * 6 - main表示方法名字，表示程序入口
  * 7 - args: Array[String]表示形参, Scala的特点是将参数名写在前面, 类型写在后面
  * 8 - Array[String]表示数组类型
  * 9 - Unit = 表示该函数的返回值为空(同Java的void)
  * 10 - println 输出语句  同Java
  *
  * Scala在设计的时候将静态从面向对象中分离出来, 形成了:
  * 静态类写在object HelloScala中
  * 非静态类型写在class HelloScala中
  * 静态和非晶态是同名的
  *
  * @author JUNN
  * @since 2019-07-20 上午 08:28
  */
object HelloScala {
  def main(args: Array[String]): Unit = {
    println("hello, scala !~~")
  }
}

