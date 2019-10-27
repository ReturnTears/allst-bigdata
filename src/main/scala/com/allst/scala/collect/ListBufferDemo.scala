package com.allst.scala.collect

import scala.collection.mutable.ListBuffer

/**
  * ListBuffer
  *
  * @author YiYa
  * @since 2019-10-27 上午 10:38
  */
object ListBufferDemo {
  def main(args: Array[String]): Unit = {
    // create
    val list = ListBuffer[Int](1, 2, 3)
    // get
    println(list(2))
    // circulation, orderly有序
    for (item <- list) {
      println(item)
    }

    // create empty collect
    val list2 = new ListBuffer[Int]
    list2 += 4
    list2.append(5)
    list2.append(6, 7, 8)

    list ++= list2

    val list3 = list ++ list2
    println(list3)

    // remove
    list3.remove(1)

  }
}
