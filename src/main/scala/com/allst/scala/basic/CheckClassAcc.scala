package com.allst.scala.basic

/**
  * 类对象和方法
  * @author YiYa
  * @since 2020/6/30-18:38
  */
class CheckClassAcc {
  private var sum = 0
  def add(b: Byte): Unit = sum += b
  def checksum(): Int = ~(sum & 0xFF) + 1
  def add2(b: Byte) {sum += b}
  def checksum2(): Int = { ~(sum & 0xFF) + 1} // 有返回值时需要带上等号
}
