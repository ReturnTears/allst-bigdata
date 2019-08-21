package com.allst.scala.guig

/**
  * 在一个字符串上调用调用getBytes方法,
  * 然后给foreach方法传入一个代码块帮助计算一个字符串的Adler-32校验码,
  * getBytes方法返回一个字符串中的有序集合字节
  * @author JUNN
  * @since 2019-08-21 下午 11:53
  */
object Adler32CheckSum {

  val MOD_ADLER = 65521

  def adler32sum(s: String): Int = {
    var a = 1
    var b = 0
    s.getBytes.foreach{ char =>
      a = (char + a) % MOD_ADLER
      b = (b + a) % MOD_ADLER
    }
    b * 65536 + a     // (b << 16) + a
  }

  def main(args: Array[String]): Unit = {
    val sum = adler32sum("wikipedia")
    printf("checksum (int) = %d\n", sum)
    printf("checksum (hex) = %s\n", sum.toHexString)
  }
}
