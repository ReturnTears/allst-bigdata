package com.allst.scala.sparkCN

import java.net.URL

import org.apache.spark.{SparkConf, SparkContext}

/**
  * 统计用户URL访问量排名前5的用户
  *
  * @author June 
  *         2018-11-01
  * @version 1.0
  */
object UrlCount {

  def main(args: Array[String]): Unit = {
    // 配置conf，可以配置AppName，部署模式，内存，CPU核心数量
    val conf = new SparkConf().setAppName("UrlCount").setMaster("local[2]")
    // 创建SC
    val sc = new SparkContext(conf)
    // 将数据切分，元祖中存放的是(URL, 1)
    var rdd1 = sc.textFile("hdfs://shizhan:9000/user/root/itcast.log").map(line => {
      val f = line.split("\t")
      (f(1), 1)
    })
    // key相同的元祖数据累加
    val rdd2 = rdd1.reduceByKey(_+_)
    // 将各个学科提取出来，便于统计、排序
    val rdd3 = rdd2.map(t => {
      val url = t._1
      val host = new URL(url).getHost
      (host, url, t._2)
    })
    // 分组并取出前5的数据
    val rdd4 = rdd3.groupBy(_._1).mapValues(it => {
      it.toList.sortBy(_._3).reverse.take(5)
    })
    // 关闭上下文之前打印一下
    println(rdd4)
    // 关闭Spark上下文
    sc.stop()
  }

}
