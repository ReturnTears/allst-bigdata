package com.allst.scala.collect

import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.mutable

/**
  * Java的List集合转Scala的ArrayBuffer
 *
  * @author YiYa
  * @since 2019-10-17 下午 09:53
  */
object JavaList2ArrayBuffer {
  def main(args: Array[String]): Unit = {
    val list = new java.util.ArrayList[Int]()
    list.add(1)
    list.add(2)

    println(list)

    val scalaArr: mutable.Buffer[Int] = list
    scalaArr.append(3)
    println(scalaArr)

  }
}
