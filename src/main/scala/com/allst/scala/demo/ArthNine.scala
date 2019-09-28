package com.allst.scala.demo

/**
  * 九九乘法表
  * @author YiYa
  * @since 2019-09-28 上午 11:15
  */
object ArthNine {
  def main(args: Array[String]): Unit = {
    for (i <- 1 to 9) {
      for (j <-  1 to i) {
        printf("%d × %d = %d \t",i ,j, i * j)
      }
      println()
    }
  }
}
