package com.allst.scala.aliscala

/**
  * Scala Study -- 基本类型及操作、程序控制结构
  * Created by June on 2018-05-15
  * @author June
  */
object AliScalaDemo {

  def main(args: Array[String]): Unit = {
    // 16进制
    val x = 0x2
    // 10进制
    val y = 3
    // 8进制:新版本Scala取消了八进制的支持
//    println(x + "\t" + y)
    val a = gcd(x, y)
  }

  def gcdLoop(x: Int, y: Int): Unit = {
    var a = x
    var b = y
    while (a != 0) {
      val temp = a
      a = b % a
      b = temp
    }
    println(a + "\t" + b)
  }

  def gcd(x: Long, y: Long): Long = if (y == 0) x else gcd(y, x % y)
  val f = (new java.io.File("C:\\Users\\June")).listFiles
//  for (file <- f) {
//    println(file)
//  }
  for (i <- 0 to f.length - 1) {
    println(f(i))
  }
}
