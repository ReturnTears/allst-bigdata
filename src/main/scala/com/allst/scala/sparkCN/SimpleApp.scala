package com.allst.scala.sparkCN

import org.apache.spark.sql.SparkSession

/**
  * @author June 
  *         2018-08-14
  * @version 1.0
  */
object SimpleApp {

  def main(args: Array[String]): Unit = {
    // hdfs上的文件，默认目录是hdfs://shizhan:9000/user/root
    val logFile = "hdfs://shizhan:9000/user/root/log.txt"
    val spark = SparkSession.builder.appName("Simple Application").getOrCreate()
    val logData = spark.read.textFile(logFile).cache()
    val numAs = logData.filter(lines => lines.contains("2")).count()
    val numBs = logData.filter(lines => lines.contains("8")).count()
    println(s"Lines with 2 : $numAs, Lines with 8 : $numBs")
    spark.stop()
  }

}
