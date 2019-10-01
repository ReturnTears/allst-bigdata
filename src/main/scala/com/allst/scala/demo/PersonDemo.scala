package com.allst.scala.demo

import scala.beans.BeanProperty

/**
  * 构造器
  *
  * @author YiYa
  * @since 2019-10-01 上午 09:28
  */
object PersonDemo {
  def main(args: Array[String]): Unit = {
    val p = new CurrPerson("JUNE", 18)
    println(p)

    val car = new Car
    car.setName("BMW")
    println(car.getName)
  }
}
class CurrPerson(inName: String, inAge: Int) {
  var name: String = inName
  var age: Int = inAge

  override def toString: String = {
    "name = " + this.inName + ", age = " + this.inAge
  }
}

// 属性的高级部分
class Car {
  @BeanProperty var name: String = _
}