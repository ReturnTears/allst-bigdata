package com.allst.scala.flink

import java.util.{Properties, Random}

import org.apache.flink.api.common.serialization.SimpleStringSchema
import org.apache.flink.streaming.api.functions.source.SourceFunction
import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer011

/**
  * Flink 流处理 Source API - 1 : 从集合中读取数据源
  * 开启kafka 生产者console测试， --topic的主题要和代码中指定的topic一致
  * bin/kafka-console-producer.sh --broker-list 192.168.2.22:9092 --topic music
  * @author YiYa
  * @since 2020-09-12 上午 09:18
  */

case class Music(name: String, age: Int, author: String, hot: Long)

object FlinkStreamSourceApi {
    def main(args: Array[String]): Unit = {
        val env = StreamExecutionEnvironment.getExecutionEnvironment
        // env.setParallelism(1)
        val dtList = List(
            Music("有心人", 1980, "zhanggr", 1234567L),
            Music("Strongest", 2020, "Alan Walker", 1234568L),
            Music("So:Lo", 2010, "Kate", 1234517L),
            Music("Fly", 2019, "Avril", 1234267L),
            Music("Victory", 2018, "Two", 1224567L)
        )
        // 从集合读取数据
        val stream = env.fromCollection(dtList)
        stream.print()
        println()

        // 从文件读取数据
        // val streamFile = env.readTextFile("E:\\IdeaProjects\\allst-scala\\src\\main\\resources\\api.txt")
        val streamFile = env.readTextFile("E:\\Projects\\IdeaProjects\\allst-scala\\src\\main\\resources\\api.txt")
        streamFile.print()

        // 从Kafka读取数据
        //val properties = new Properties()
        //properties.setProperty("bootstrap.servers", "192.168.2.22:9092")
        //properties.setProperty("group.id", "consumer-group")
        //val  streamKafka = env.addSource(new FlinkKafkaConsumer011[String]("music", new SimpleStringSchema(), properties))
        //streamKafka.print()

        // 自定义Source
        val streamDef = env.addSource(new MyMusicFunction)
        streamDef.print()

        // 执行
        env.execute("api exec")
    }
}

// 自定义SourceFunction
class MyMusicFunction extends SourceFunction[Music] {

    var running: Boolean = true

    override def run(sourceContext: SourceFunction.SourceContext[Music]): Unit = {
        val r = new Random()
        var temp = 1.to(10).map(i => ("Victory_" + i, r.nextDouble() * 20))
        while (running) {
            temp = temp.map(
                data => (data._1, data._2 + r.nextGaussian())
            )
            val time = System.currentTimeMillis()
            temp.foreach(t => sourceContext.collect(Music(t._1, t._2.toInt, time.toString, r.nextLong())))

            // 模拟间隔时间
            Thread.sleep(2000)
        }
    }

    override def cancel(): Unit = running = false
}