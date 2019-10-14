package com.allst.scala.impli

/**
  * 隐式值
  * @author YiYa
  * @since 2019-10-14 下午 09:49
  */
object ImplicitVal {
  def main(args: Array[String]): Unit = {

    // 隐式值
    implicit val str: String = "jack"

    // name是隐式参数
    def hello(implicit name: String): Unit = {
      println(name + " , Hello")
    }

    hello     // 调用不参(),带了()不传递参数会报错,   底层是hello$1(str)

  }
}
