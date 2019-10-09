package com.allst.scala.demo

/**
  * scala的抽象累
  * @author YiYa
  * @since 2019-10-09 下午 09:55
  */
object AbstractDemo {
  def main(args: Array[String]): Unit = {
    // 同Java一致,
    val mon = new Monster {
      override var name: String = "Hello"

      override def cry(): Unit = {
        println(name)
      }
    }
    mon.cry()
  }
}

abstract class Animal {
  var name: String
  var age: Int
  val color: String = "block"
}

/**
  * 抽象类也可以有实现方法
  */
abstract class Animal2 {
  def sayHi():Unit = {
    println("animal2 sayHi")
  }
}

abstract class Animal3 {
  def sayHello()
}

// Scala的匿名子类
abstract class Monster {
  var name: String
  def cry()
}
