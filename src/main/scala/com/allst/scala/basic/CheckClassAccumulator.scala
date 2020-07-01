package com.allst.scala.basic

/**
  * 单例对象
  *
  * @author YiYa
  * @since 2020/6/30-18:49
  */
object CheckClassAccumulator {
  private var cache = Map[String, Int]()

  def calculate(s: String): Int =
    if (cache.contains(s))
      cache(s)
    else {
      val acc = new CheckClassAccumulator // object CheckClassAccumulator叫做单例对象，单例对象与class CheckClassAccumulator同名时， 这个单例对象又被称为class的伴生对象
      for (c <- s)
        acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (s -> cs)
      cs
    }
}

class CheckClassAccumulator {
  private var sum = 0
  def add(b: Byte): Unit = sum += b
  def checksum(): Int = ~(sum & 0xFF) + 1
}
