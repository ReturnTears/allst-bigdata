package com.allst.scala.flink

import org.apache.flink.streaming.api.functions.source.SourceFunction

/**
  * 自定义实现并行度为1的Source
  *
  * @author YiYa
  * @since 2020/7/8-16:12
  */
class FlinkNoParalleSourceScala extends SourceFunction[Long] {

  var count = 1L
  var isRunning = true

  override def run(sourceContext: SourceFunction.SourceContext[Long]): Unit = {
    while (isRunning) {
      sourceContext.collect(count)
      count += 1
      Thread.sleep(1000)
    }
  }

  override def cancel(): Unit = {
    isRunning = false
  }
}
