package com.allst.scala.collect

/**
  * 扫描, 保存每次运行后得结果
  * Scan
  * @author YiYa
  * @since 2019-11-03 上午 08:49
  */
object ScanDemo {
  def main(args: Array[String]): Unit = {
    // 5 (1,2,3,4,5) => (5, 4, 2, -1, -5, -10)
    // 保留最开始的值5, (5-1), (5-1-2), (5-1-2-3)...
    val leftSc = (1 to 5).scanLeft(5)(miuns2)
    println(leftSc)
    // (1,2,3,4,5) 10 => (... 14,10, 5)
    val rightSc = (1 to 5).scanRight(5)(miuns2)
    println(rightSc)
  }

  def miuns2(n1: Int, n2: Int): Int = {
    n1 - n2
  }

  def sum2(n1: Int, n2: Int): Int = {
    n1 + n2
  }
}
