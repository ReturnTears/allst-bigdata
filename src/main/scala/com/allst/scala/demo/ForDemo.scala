package com.allst.scala.demo

/**
  * @author JUNN
  * @since 2019-09-26 下午 10:18
  */
object ForDemo {
  def main(args: Array[String]): Unit = {
    /*val start = 1
    val end = 10
    for (i <- start to end) {
      println("Hello For " + i)
    }*/

    // 调用
    for3_Demo()
  }

  def forDemo(): Unit = {
    var list = List("hello", 10, 30, "tom")
    // 左闭右闭区间
    for (item <- list) {
      println("item = " + item)
    }
  }

  def untilDemo(): Unit = {
    val start = 1
    val end = 10
    // 左闭右开区间
    for (i <- start until end) {
      println(i)
    }
  }

  // 循环守卫
  def ifDemo(): Unit = {
    for (i <- 1 to 3 if i != 2) {
      println(i)
    }
  }

  /**
    * 没有关键字,所以范围后一定要加分号; 来隔断逻辑
    */
  def for_Demo(): Unit = {
    for (i <- 1 to 3; j = 4 -i) {
      println(j)
    }
    // 等价于
    for (i <- 1 to 3) {
      val j = 4 -i
      println(j)
    }
  }

  // for循环的嵌套
  def for2_Demo(): Unit = {
    for (i <- 1 to 3; j <- 1 to 3) {
      println("i = " + i + ", j = " + j)
    }

    // 上面这句等价于
    for (i <- 1 to 3) {
      for (j <- 1 to 3) {
        println("i = " + i + ", j = " + j)
      }
    }
  }

  /**
    * for循环结合yield
    * yield i将每次循环得到i放入集合vector中, 并返回给res
    * i在这里是代码块, 意味着我们可以对i进行处理
    */
  def for3_Demo(): Unit = {
    val res = for (i <- 1 to 10) yield i
    println(res)
  }
}
