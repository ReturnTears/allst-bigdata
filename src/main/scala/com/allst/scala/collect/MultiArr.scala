package com.allst.scala.collect

/**
  * 多维数组
  * @author YiYa
  * @since 2019-10-17 下午 09:33
  */
object MultiArr {
  def main(args: Array[String]): Unit = {
    // 创建
    val arr = Array.ofDim[Int](2,3)
    // 遍历
    for (item <- arr) {
      for (i <- item) {
        print(i + "\t")
      }
      println()
    }
    // f赋值
    arr(1)(1) = 7
    // 取值
    val a = arr(1)(1)
    println(a)
    // 按照下标的方式来遍历
    for (i <- 0 to arr.length - 1) {
      for (j <- 0 until arr(i).length) {
        printf("arr[%d][%d] = %d\t", i, j, arr(i)(j))
      }
      println()
    }
  }
}
