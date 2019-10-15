package com.allst.scala.impli

/**
  * 隐式类案例
  * @author YiYa
  * @since 2019-10-15 下午 10:17
  */
object ImplicitClass {
  def main(args: Array[String]): Unit = {
    // AllImpl是一个隐式类, 在隐式类的作用域范围内, 创建MyImpl实例时, 隐式类就会生效, 转换工作由编译器完成
    implicit class AllImpl(val my: MyImpl) {
      def addSuffix(): String = {
        println(" Scala")
        my + " Scala"
      }
    }

    // 创建MyImpl的实例
    val my = new MyImpl
    my.sayHi()
    my.addSuffix()    // 底层编译器生成了: AllImpl$1(my).addSuffix()
  }
}
class MyImpl {
  def sayHi(): Unit = {
    println("Hi")
  }
}