package com.allst.scala.impli

/**
  * 隐式值案例
  * @author YiYa
  * @since 2019-10-14 下午 10:03
  */
object ImplicitValEg {
  def main(args: Array[String]): Unit = {
    /*// 案例1: 有两个隐式值, 编译器不知道匹配哪一个隐式值, 注释一个即可
    implicit val name: String = "scala"

    // implicit val name2: String = "java"

    def hello2(implicit content: String = "JavaScript"): Unit = {
      println("hello " + content)
    }

    hello2*/


    // 同时有implicit修饰得隐式值和默认参数, 隐式值得优先级高
    /*implicit val name: String = "JavaScript"

    def hello3(implicit content: String = "Scala"): Unit = {
      println("hello " + content)
    }

    hello3*/


    // 当一个隐式参数匹配不到隐式值时任然会使用默认值
    /*implicit val age: Int = 7
    def hello4(implicit yr: String = "age"): Unit = {
      println("hello " + yr)
    }

    hello4*/

    // 没有隐式值, 没有默认值, 没有传值时,就会报错
    def hello5(implicit yr: String): Unit = {
      println("hello " + yr)
    }

    // hello5
  }
}
