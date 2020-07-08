package com.allst.scala.flink

import org.apache.flink.streaming.api.functions.source.{ParallelSourceFunction, SourceFunction}

/**
  * 自定义实现一个支持多并行度的Source
  *
  * @author YiYa
  * @since 2020/7/8-16:21
  */
class FlinkParalleSourceScala extends ParallelSourceFunction[Long] {
  var count = 1L
  var isRunning = true

  override def run(sourceContext: SourceFunction.SourceContext[Long]): Unit = {
    while (isRunning) {
      sourceContext.collect(count)
      count += 1
      Thread.sleep(1000)
    }
  }

  override def cancel(): Unit = isRunning = false
}
