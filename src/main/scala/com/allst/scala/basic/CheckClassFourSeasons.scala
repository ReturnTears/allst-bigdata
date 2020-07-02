package com.allst.scala.basic

import CheckClassAccumulator.calculate

/**
  * Scala特质App 可以替换main主方法
  *
  * @author YiYa
  * @since 2020/7/1-11:07
  */
object CheckClassFourSeasons extends App {
  for (season <- List("fall", "winter", "spring", "summer"))
    println(season + " : " + calculate(season))
}
