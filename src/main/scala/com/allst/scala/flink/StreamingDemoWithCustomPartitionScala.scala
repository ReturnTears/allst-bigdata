package com.allst.scala.flink

import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment

/**
  * 使用自定义的FlinkCustomPartitioner分区
  * @author YiYa
  * @since 2020/7/8-17:08
  */
object StreamingDemoWithCustomPartitionScala {
  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    env.setParallelism(2)

    // 隐式转换
    import org.apache.flink.api.scala._
    val text = env.addSource(new FlinkNoParalleSourceScala)

    // 把Long类型的数据转换成Tuple类型
    val tupleData = text.map(line => {
      Tuple1(line)
    })

    val partitionData = tupleData.partitionCustom(new FlinkCustomPartitionerScala, 0)

    val result = partitionData.map(line => {
      println("当前线程id: " + Thread.currentThread().getId + ", value : " + line)
      line._1
    })

    result.print().setParallelism(1)
    env.execute("StreamingDemoWithCustomPartition")
  }
}
