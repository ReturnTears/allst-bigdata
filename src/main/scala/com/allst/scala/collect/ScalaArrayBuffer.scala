package com.allst.scala.collect

import scala.collection.mutable.ArrayBuffer

/**
  * ArrayBuffer
 *
  * @author YiYa
  * @since 2019-10-16 下午 11:25
  */
object ScalaArrayBuffer {
  def main(args: Array[String]): Unit = {
    // 创建
    val arr = ArrayBuffer[Any](3,2,5)
    // 访问
    println(arr(1))
    // 遍历
    for (i <- arr) {
      println(i)
    }
    // 数组的长度
    println(arr.length)
    // arr的hash
    println("arr.hash = " + arr.hashCode())
    // 追加, 可以理解为Java数组的扩容
    arr.append(7,8,11)
    //
    println("arr.hash = " + arr.hashCode())

    // 通过下标删除元素, 不可变的数组不会有删除方法
    arr.remove(1)

  }
}
