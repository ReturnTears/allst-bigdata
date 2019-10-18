package com.allst.scala.collect

/**
  * Scala的List
  * @author YiYa
  * @since 2019-10-18 下午 09:28
  */
object ScalaListDemo {
  def main(args: Array[String]): Unit = {
    // 创建时分配元素
    val list = List(1,2,3,4)
    println(list)
    // 空集合, 跟null不一样
    val list2 = Nil
    println(list2)
  }
}
