package com.allst.scala.guig.demo

/**
  * 数据类型转换
  * @author JUNN
  * @since 2019-07-27 上午 02:17
  */
object DataTypeTransform {
  def main(args: Array[String]): Unit = {
    var n1 = 10
    var n2 = 1.1
    var n3 = n1 + n2

    var n4:Byte = 10
    // 大精度赋值给小精度就会报错
    //var n5:Char = n4
  }
}
