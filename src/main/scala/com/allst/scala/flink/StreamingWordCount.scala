package com.allst.scala.flink

import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}
import org.apache.flink.api.scala._
import org.apache.hadoop.mapred.TextOutputFormat

/**
  * Streaming Word Count
  * 运行环境:centos7 flink集群
  *
  * @author YiYa
  * @since 2020/8/12-17:22
  */
object StreamingWordCount {
  def main(args: Array[String]): Unit = {
    // one 设置环境
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    // two 指定数据源地址， 读取输入数据
    var text = env.readTextFile("file:///root/data/inp.txt")
    // three 转换逻辑
    val counts: DataStream[(String, Int)] = text.flatMap(_.toLowerCase.split(" "))
      .filter(_.nonEmpty)
      .map((_, 1))
      .keyBy(0)
      .sum(1)
    // four: 指定计算结果输出位置
    val params = ""
    if (params.contains("output")) {
      counts.writeUsingOutputFormat(TextOutputFormat[(String, Int)])
    }
    counts.print()
    env.execute("Streaming WordCount")
  }
}
