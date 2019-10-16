package com.allst.scala.collect

/**
  * Scala的集合
  * @author YiYa
  * @since 2019-10-16 下午 10:18
  */
object ScalaCollect {
  def main(args: Array[String]): Unit = {
    //
    for (item <- "hello") {
      println(item)
    }

    // 数组
    val arr1 = new Array[Int](10)
    // 声明任意类型的数组
    val arr2 = new Array[Any](10)

    arr1(0) = 7
    println(arr1.length)
  }
}
