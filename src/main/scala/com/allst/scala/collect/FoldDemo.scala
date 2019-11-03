package com.allst.scala.collect

/**
  * fold 折叠的理解和化简得运行机制几乎一致
  * @author YiYa
  * @since 2019-11-03 上午 08:37
  */
object FoldDemo {
  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,4)
    // 可用理解为List(5, 1,2,3,4)
    // (((5 - 1) - 2) - 3) - 4
    println(list.foldLeft(5)(minus2)) // 函数得柯里化
    // 可用理解为List(1,2,3,4, 5)
    // 1 - (2 - (3 - (4 - 5)))
    println(list.foldRight(5)(minus2))

    // 折叠简写
    val fold1 = (5 /: list)(minus2)
    println(fold1)

    val  fold2 = (list :\ 5)(minus2)
    println(fold2)
  }


  def minus2(n1: Int, n2: Int): Int = {
    n1 - n2
  }
}
