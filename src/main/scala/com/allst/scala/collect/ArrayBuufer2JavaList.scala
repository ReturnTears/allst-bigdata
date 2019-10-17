package com.allst.scala.collect

import scala.collection.mutable.ArrayBuffer

/**
  * Scala数组转换Java list集合
 *
  * @author YiYa
  * @since 2019-10-17 下午 09:42
  */
object ArrayBuufer2JavaList {
  def main(args: Array[String]): Unit = {
    val arr = ArrayBuffer("1", "2", "3")
    println(arr)

    import scala.collection.JavaConversions.bufferAsJavaList
    val javaArr = new ProcessBuilder(arr)

    val arrList = javaArr.command()
    println(arrList)

  }
}
