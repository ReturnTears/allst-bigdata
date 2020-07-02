package com.allst.scala.basic

import CheckClassAccumulator.calculate
/**
  * CheckClassSummer是单例对象
  *
  * @author YiYa
  * @since 2020/7/1-10:37
  */
object CheckClassSummer {
  def main(args: Array[String]): Unit = {
    for (arg <- args) {
      println(arg + " : " + calculate(arg))
    }
  }
}
