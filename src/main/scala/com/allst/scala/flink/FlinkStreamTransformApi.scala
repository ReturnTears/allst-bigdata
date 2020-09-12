package com.allst.scala.flink

import org.apache.flink.api.common.functions.ReduceFunction
import org.apache.flink.streaming.api.scala._

/**
  * Flink 流处理 Transform API
  *
  * @author YiYa
  * @since 2020-09-12 下午 04:27
  */
object FlinkStreamTransformApi {
    def main(args: Array[String]): Unit = {
        val env = StreamExecutionEnvironment.getExecutionEnvironment
        env.setParallelism(1)
        // 从文件读取数据源
        val inputPath = "E:\\IdeaProjects\\allst-scala\\src\\main\\resources\\api.txt"
        val inputStream = env.readTextFile(inputPath)

        val dataStream = inputStream.map(dt => {
            val arr = dt.split(",")
            Music(arr(0), arr(1).toInt, arr(2), arr(3).toLong)
        })
        // 分组聚合
//        val aggStream = dataStream.keyBy("name").minBy("age")
//        aggStream.print()

        // reduce
        val resultStream = dataStream.keyBy("name").reduce(
            (curr, newDt) => Music(curr.name, curr.age.min(newDt.age), newDt.author, curr.hot.max(newDt.hot))
        )
        //resultStream.print()

        // 自定义reduce实现
        val resultStreamer = dataStream.keyBy("name").reduce(new MyReduceFunction)
        //resultStreamer.print()

        // 分流 - split：按照热度划分
        val splitStream = dataStream.split(data => {
            if (data.hot > 1234567L) Seq("High") else Seq("Lower")
        })
        val high = splitStream.select("High")
        val low = splitStream.select("Lower")
        val all = splitStream.select("Lower", "High")
//        high.print("high")
//        low.print("Lower")
//        all.print("all")

        // 合流: connect
        val warnings = high.map(data => (data.name, data.hot))
        val connectedStreams = warnings.connect(low)
        // 使用coMap对数据进行分别处理
        val coMapResult: DataStream[Any] = connectedStreams.map(
            h => (h._1, h._2, "/(ㄒoㄒ)/~~"),
            l => (l.name, "Yes^_^")
        )
        coMapResult.print("connect")

        // 合流：union, 需要类型相同， 比较简单，可以传递多个参数
        val unionStream = high.union(low)
        unionStream.print()

        env.execute("transform exec")
    }
}

class MyReduceFunction extends ReduceFunction[Music] {
    override def reduce(t: Music, t1: Music): Music = {
        Music(t.name, t.age.min(t1.age), t1.author, t.hot.max(t1.hot))
    }
}