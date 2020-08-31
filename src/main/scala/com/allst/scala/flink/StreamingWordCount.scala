package com.allst.scala.flink

import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}
import org.apache.flink.api.scala._
import org.apache.hadoop.mapred.TextOutputFormat

/**
  * Streaming Word Count
  * 运行环境:centos7 flink集群
  * nc命令(net cat)可以创建一个以TCP或者UDP方式去监听一个指定的端口
  * nc -lk 9999
  * l表示启动一个server,去监听一个端口
  * k表示keep， 保持住
  * @author YiYa
  * @since 2020/8/12-17:22
  */
object StreamingWordCount {
  def main(args: Array[String]): Unit = {
    // one 设置环境
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    // two 指定数据源地址， 读取输入数据
    // var text = env.readTextFile("file:///root/data/inp.txt")
    var text = env.socketTextStream("localhost", 9999)
    // three 转换逻辑
    val counts: DataStream[(String, Int)] = text.flatMap(_.toLowerCase.split(" "))
      .filter(_.nonEmpty)
      .map((_, 1))
      .keyBy(0)
      .sum(1)
    // four: 指定计算结果输出位置
    /*val params = ""
    if (params.contains("output")) {
      counts.writeUsingOutputFormat(TextOutputFormat[(String, Int)])
    }*/
    counts.print()

    // four 调用环境启动任务执行
    env.execute("Streaming WordCount")
  }
}
