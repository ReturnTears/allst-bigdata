package com.allst.scala.aliscala

import scala.collection.mutable.ArrayBuffer

/**
  * @author June
  * @version 1.0
  */
object AliScalaSwitchDemo extends App {
  var list = new ArrayBuffer[Int]()
  var x = 0
  for (i <- 1 to 100) {
    i match {
      case 10 => println("匹配的数字为 : 10")
      case 50 => println("匹配的数字为 : 50")
      case 80 => x = 80
      case _ if (i % 4 == 0) => println(i + " 能被4整除的数字")
      case _ if (i % 15 == 0)=> list.append(i)
      case _ =>
    }
  }
  println(x)
}
