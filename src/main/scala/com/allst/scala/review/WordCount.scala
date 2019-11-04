package com.allst.scala.review

import org.apache.spark.{SparkConf, SparkContext}

/**
  * WordCount单词计数
 *
  * @author YiYa
  * @since 2019-11-05 上午 12:09
  */
object WordCount {
  def main(args: Array[String]): Unit = {
    // 创建SparkConf对象
    val conf = new SparkConf().setAppName("YiYa Application")
    // 创建SparkContext对象
    val sc = new SparkContext(conf)
    //
    val logFIle = "/root/demo.txt"
    val logData = sc.textFile(logFIle, 2).cache()
    val numHello = logData.filter(line => line.contains("hello")).count()
    val numHi = logData.filter(line => line.contains("hi")).count()
    println("words with hello : s%, words with hi : s%".format(numHello, numHi))
  }
}
