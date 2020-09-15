package com.allst.scala.flink

import org.apache.flink.api.common.serialization.SimpleStringEncoder
import org.apache.flink.core.fs.Path
import org.apache.flink.streaming.api.functions.sink.filesystem.StreamingFileSink
import org.apache.flink.streaming.api.scala._

/**
  * Flink 流处理 Sink API
  *
  * @author YiYa
  * @since 2020-09-13 上午 11:52
  */
object FlinkStreamSinkApi {
    def main(args: Array[String]): Unit = {
        val env = StreamExecutionEnvironment.getExecutionEnvironment
        // env.setParallelism(1)
        // 从文件读取数据源
        val inputPath = "E:\\Projects\\IdeaProjects\\allst-scala\\src\\main\\resources"
        //val inputPath = "E:\\IdeaProjects\\allst-scala\\src\\main\\resources"
        val inputStream = env.readTextFile(inputPath + "\\api.txt")

        val dataStream = inputStream.map(dt => {
            val arr = dt.split(",")
            Music(arr(0), arr(1).toInt, arr(2), arr(3).toLong)
        })

        dataStream.print()
        // dataStream.writeAsCsv(inputPath + "\\sink.txt")
        dataStream.addSink(StreamingFileSink.forRowFormat(
            new Path(inputPath + "\\sink2.txt"),
            new SimpleStringEncoder[Music]()
        ).build())

        env.execute("sink exec")
    }
}
