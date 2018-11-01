package com.allst.scala.aliscala

import java.io.FileWriter
import java.net.URL

import scala.io.Source

/**
  * @author June on 2018-06-15
  *         Scala I/O 操作
  *         在Scala中，它更多的是调用java中的I/O类或者通过对java中的I/O类进行相应的封装来实现I/O操作。
  */
object AliScalaIO {
  def main(args: Array[String]): Unit = {
    new ScalaIO().regexMatchPhone()
  }
}
class ScalaIO {
  def scalaWrite(): Unit = {
    val fileWriter = new FileWriter("file.txt")
    fileWriter.write("scala file write...")
    fileWriter.flush()
    fileWriter.close()
  }

  def scalaRead(): Unit = {
    val file = Source.fromFile("D:\\GoogleDownload\\hbase.version")
    val lines = file.getLines()
    for (i <- lines) println(i)
    file.close()
  }

  def scalaNetIO(): Unit = {
    println(Source.fromURL(new URL("https://www.baidu.com")).mkString)
  }

  def regexMatchEmail(): Unit = {
    // 邮箱匹配
    val sparkRegex = "^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$".r
    for (matchStr <- sparkRegex.findAllIn("zhouzhihubeyond@sina.com")) {
      println(matchStr)
    }
  }

  def regexMatchUrl(): Unit = {
    // ^[a-zA-Z]+://(\\w+(-\\w+)*)(\\.(\\w+(-\\w+)*))*(\\?\\s*)?$
    val sparkRegex = "^[a-zA-Z]+://(\\w+(-\\w+)*)(\\.(\\w+(-\\w+)*))*(\\?\\s*)?$".r
    for (matchStr <- sparkRegex.findAllIn("https://www.baidu.com")) {
      println(matchStr)
    }
  }

  def regexMatchPhone(): Unit = {
    // 匹配手机号
    val sparkRegexPhone = "(86)*0*1\\d{10}".r
    for (matchStr <- sparkRegexPhone.findAllIn("18426270790")) {
      if (matchStr.length > 0) {
        println(matchStr)
      }
    }
  }

  def regexMatchIp(): Unit = {
    val sparkRegexIp = "(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)".r
    for (matchStr <- sparkRegexIp.findAllIn("127.0.0.1")) {
      println(matchStr)
    }
  }

  // 提取匹配的IP地址子段
  def regexMatchIpChild(): Unit ={
    val ipRegex = "(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)".r
    for (ipRegex(one, two, three, four) <- ipRegex.findAllIn("192.168.1.1")) {
      println("ip 子段1 ：" + one)
      println("ip 子段1 ：" + two)
      println("ip 子段1 ：" + three)
      println("ip 子段1 ：" + four)
    }
  }

  // 提取邮箱中的用户名
  def sparkRegex(): Unit = {
    val sparkRegex = "^([\\w-]+(\\.[\\w-]+)*)@[\\w-]+(\\.[\\w-]+)+$".r
    for (sparkRegex(domainName,_*) <- sparkRegex.findAllIn("zhouzhihubeyond@sina.com")) {
      println(domainName)
    }
  }
}