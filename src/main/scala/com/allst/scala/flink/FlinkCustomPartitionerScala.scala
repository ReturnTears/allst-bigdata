package com.allst.scala.flink

import org.apache.flink.api.common.functions.Partitioner

/**
  * @author YiYa
  * @since 2020/7/8-17:06
  */
class FlinkCustomPartitionerScala extends Partitioner[Long] {
  override def partition(k: Long, i: Int): Int = {
    println("分区总数: " + i)
    if (k % 2 == 0) {
      0
    } else {
      1
    }
  }
}
