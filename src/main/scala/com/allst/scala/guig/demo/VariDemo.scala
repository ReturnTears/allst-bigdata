package com.allst.scala.guig.demo

/**
  * 变量的声明及使用
  * @author JUNN
  * @since 2019-07-21 上午 11:43
  */
object VariDemo {
  def main(args: Array[String]): Unit = {
    var cat = new Cat()
    // 下面这句会报错,查看Part15部分
    // cat.name = ""
    cat.age = 20
    println(s"${cat.name} , ${cat.age}")
  }
}

class Cat {
  val name: String = "HelloKitty"
  var age: Int = 18
}

// Scala的数据类型
class DataType {
  var num1: Int = 10

}