package com.allst.scala.flink

import org.apache.flink.api.scala.ExecutionEnvironment

/**
  * 单词计数之离线计算
  *
  * @author YiYa
  * @since 2020/7/8-11:40
  */
object BatchWordCountScala {
  def main(args: Array[String]): Unit = {
    val input = "E:\\TestData\\file\\input"
    val output = "E:\\TestData\\file\\scalaOut"
    // 获取运行环境
    val env = ExecutionEnvironment.getExecutionEnvironment
    val text = env.readTextFile(input)

    // 引入隐式转换
    import org.apache.flink.api.scala._
    val counts = text.flatMap(_.toLowerCase.split("\\W+"))
      .filter(_.nonEmpty)
      .map((_, 1))
      .groupBy(0)
      .sum(1)

    counts.writeAsCsv(output, "\n", " ").setParallelism(1)
    env.execute("batch word count")
  }
}
