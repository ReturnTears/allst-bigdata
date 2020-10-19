package com.allst.scala.flink

import org.apache.flink.api.common.serialization.SimpleStringSchema
import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer011

/**
  * 将Flink处理后的结果添加到Kafka
  *
  * @author YiYa
  * @since 2020-09-14 下午 09:06
  */
object FlinkStreamSink2Kafka {
    def main(args: Array[String]): Unit = {
        val env = StreamExecutionEnvironment.getExecutionEnvironment
        //val inputPath = "E:\\Projects\\IdeaProjects\\allst-scala\\src\\main\\resources"
        val inputPath = "E:\\IdeaProjects\\allst-scala\\src\\main\\resources"
        val inputStream = env.readTextFile(inputPath + "\\api.txt")

        val dataStream = inputStream.map(dt => {
            val arr = dt.split(",")
            Music(arr(0), arr(1).toInt, arr(2), arr(3).toLong).toString
        })

        dataStream.addSink(new FlinkKafkaProducer011[String]("192.168.2.22:9092", "music", new SimpleStringSchema()))

        env.execute("kafka sink exec")
    }
}
