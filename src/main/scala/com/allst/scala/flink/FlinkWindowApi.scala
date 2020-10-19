package com.allst.scala.flink

import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.api.windowing.assigners.{EventTimeSessionWindows, SlidingProcessingTimeWindows, TumblingEventTimeWindows}
import org.apache.flink.streaming.api.windowing.time.Time
/**
  * Flink窗口Api
  *
  * @author YiYa
  * @since 2020-10-19 下午 11:00
  */
object FlinkWindowApi {
    def main(args: Array[String]): Unit = {
        val env = StreamExecutionEnvironment.getExecutionEnvironment
        // env.setParallelism(1)
        // 从文件读取数据源
        //val inputPath = "E:\\Projects\\IdeaProjects\\allst-scala\\src\\main\\resources"
        val inputPath = "E:\\IdeaProjects\\allst-scala\\src\\main\\resources"
        val inputStream = env.readTextFile(inputPath + "\\api.txt")

        val dataStream = inputStream.map(dt => {
            val arr = dt.split(",")
            Music(arr(0), arr(1).toInt, arr(2), arr(3).toLong)
        })

        val resultStream = dataStream.map(dt => (dt.name, dt.author))
          .keyBy(_._1)
          // 滚动时间窗口
          //.window(TumblingEventTimeWindows.of(Time.seconds(15)))
          // 滑动时间窗口
          //.window(SlidingProcessingTimeWindows.of(Time.seconds(15), Time.seconds(10)))
          // 会话窗口
          .window(EventTimeSessionWindows.withGap(Time.seconds(10)))
    }
}
