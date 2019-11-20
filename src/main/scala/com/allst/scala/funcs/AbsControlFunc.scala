package com.allst.scala.funcs

/**
  * 抽象控制案例
  * @author YiYa
  * @since 2019-11-20 下午 10:55
  */
object AbsControlFunc {
    def main(args: Array[String]): Unit = {
        testWhile()

        // 使用抽象控制
        var x = 13
        likeWhile(x > 7) {
            x -= 2
            println("likeWhile >: " + x)
        }
    }

    /**
      * while循环
      */
    def testWhile(): Unit = {
        var n = 7
        while (n > 0) {
            n -= 1
            println("n = " + n)
        }
    }

    /**
      * 使用抽象控制编写类似while的语句
      * @param cond     条件
      * @param block    代码块
      */
    def likeWhile(cond: => Boolean)(block: => Unit): Unit = {
        if (cond) {
            block
            // 递归调用
            likeWhile(cond)(block)
        }
    }
}
