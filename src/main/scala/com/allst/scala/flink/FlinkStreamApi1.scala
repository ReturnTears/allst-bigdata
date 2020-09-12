package com.allst.scala.flink

import java.util.Properties

import org.apache.flink.api.common.serialization.SimpleStringSchema
import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer011

/**
  * Flink 流处理 Source API - 1 : 从集合中读取数据源
  * 开启kafka 生产者console测试， --topic的主题要和代码中指定的topic一致
  * bin/kafka-console-producer.sh --broker-list 192.168.2.22:9092 --topic music
  * @author YiYa
  * @since 2020-09-12 上午 09:18
  */

case class Music(name: String, age: Int, author: String)

object FlinkStreamApi1 {
    def main(args: Array[String]): Unit = {
        val env = StreamExecutionEnvironment.getExecutionEnvironment
        // env.setParallelism(1)
        val dtList = List(
            Music("有心人", 1980, "zhanggr"),
            Music("Strongest", 2020, "Alan Walker"),
            Music("So:Lo", 2010, "Kate"),
            Music("Fly", 2019, "Avril"),
            Music("Victory", 2018, "Two")
        )
        // 从集合读取数据
        val stream = env.fromCollection(dtList)
        stream.print()
        println()

        // 从文件读取数据
        //val streamFile = env.readTextFile("E:\\IdeaProjects\\allst-scala\\src\\main\\resources\\api.txt")
        val streamFile = env.readTextFile("E:\\Projects\\IdeaProjects\\allst-scala\\src\\main\\resources\\api.txt")
        streamFile.print()

        // 从Kafka读取数据
        val properties = new Properties()
        properties.setProperty("bootstrap.servers", "192.168.2.22:9092")
        properties.setProperty("group.id", "consumer-group")
        val  streamKafka = env.addSource(new FlinkKafkaConsumer011[String]("music", new SimpleStringSchema(), properties))
        streamKafka.print()
        // 执行
        env.execute("api exec")
    }
}