package com.allst.scala.funcs

/**
  * 作为函数的参数
  * @author YiYa
  * @since 2019-11-18 下午 10:23
  */
object FunctionParam {
    def main(args: Array[String]): Unit = {
        def plusFour(x: Int) = x + 4
        val list = List(1,2,3,4).map(plusFour(_))
        println(list)
        // 这里的下划线表示将: 函数的引用传递过去
        println("plusFour类型 : " + plusFour _)
    }
}
