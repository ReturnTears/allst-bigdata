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

    // 方法的调用带不带小括号都一样
    maVal

    println(sayHello)

  }

  // 在开发中, 我们有一个方法就会异常中断, 这时候就可以返回Nothing,
  // 即当我们Nothing做返回值, 就是明确说明该方法没有正常返回值
  def sayHello: Nothing = {
    throw new Exception("抛出异常")
  }

  //
  def maVal= {
    println(Int.MaxValue)
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