package com.allst.scala.collect

/**
  * 并行集合
  * @author YiYa
  * @since 2019-11-03 下午 05:20
  */
object PerDemo {
  def main(args: Array[String]): Unit = {
    // 单线程执行
    (1 to 7).foreach(println(_))
    println()
    // 输出的结果是无序的, 说明将任务分配给了不同cpu
    (1 to 1000).par.foreach(println(_))
    println("--------------------------")

    method01()
    println("+++++++++++++++")
    method02()

  }

  /**
    * 非并行
    */
  def method01(): Unit = {
    val result1 = (0 to 100).map {
      case _ => Thread.currentThread.getName
    }.distinct
    println(result1)
  }

  /**
    * 并行
    */
  def method02(): Unit = {
    val result2 = (0 to 100).par.map {
      case _ => Thread.currentThread.getName
    }.distinct
    println(result2)
  }

}
