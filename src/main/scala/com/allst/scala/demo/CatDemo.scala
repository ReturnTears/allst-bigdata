package com.allst.scala.demo

/**
  * @author YiYa
  * @since 2019-09-29 下午 09:53
  */
object CatDemo {
  def main(args: Array[String]): Unit = {
    val cat = new Cat
    // cat.name其实不是直接访问属性, 而是cat.name_$eq("JUNN")
    cat.name = "JUNN"
    cat.age = 7
    cat.color = "pink"
  }
}

/**
  * 定义类, 属性必须给初始值
  */
class Cat {
  var name: String = ""     // 底层对应private name
  var age: Int = _
  var color: String = _
}