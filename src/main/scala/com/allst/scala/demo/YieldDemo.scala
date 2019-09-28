package com.allst.scala.demo

/**
  * @author JUNN
  * @since 2019-09-28 上午 10:51
  */
object YieldDemo {
  def main(args: Array[String]): Unit = {
    /** yield后面可以跟代码块, 我们可以对其进行处理,
      * 将处理的结果集放到集合Vector中并返回
      */
    var res = for (i <- 1 to 10) yield i * 2
    println(res)

    /**
      * 控制步长, 采用Range
      */
    for (i <- Range(1, 10, 2)) {
      println("i = " + i)
    }
    // 控制步长, 采用循环守卫
    for (i <- 1 to 10 if i % 2 == 1) {
      println("i = " + i)
    }
  }
}
