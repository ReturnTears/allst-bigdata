package com.allst.scala.aliscala

/**
  * @author June 
  *         2018-07-11
  * @version 1.0
  */
object AliScalaGenericDemo {
  def main(args: Array[String]): Unit = {
    println(new StuPer[String]("杨杨").name)

    println(new TeaPer[String, Int]("小胡", 18).name)
  }
}
// 单个泛型参数的使用情况
class Personal[T](var name: T)
class StuPer[T](name: T) extends Personal(name)
// 多个泛型参数的使用情况
class TeaPer[T, S](name: T, var age: S) extends Personal(name)
