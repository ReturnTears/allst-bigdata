package com.allst.scala.collect

/**
  * 拉链
  * @author YiYa
  * @since 2019-11-03 下午 04:10
  */
object ZipDemo {
  def main(args: Array[String]): Unit = {

    val list1 = List(1, 3, 5, 7)
    val list2 = List(2, 4, 6)

    val list3 = list1.zip(list2)
    println(list3)
  }
}
