package com.allst.scala.recursion

/**
  * 递归案例
  * @author YiYa
  * @since 2019-11-21 下午 10:41
  */
object RecursionMax {
    def main(args: Array[String]): Unit = {
        val list = List(1,2,33,12,90)
        println(calcMax(list))

        println(reverseStr("Hello"))

        println(factorial(7))
    }

    // 递归计算出List列表中最大值
    def calcMax(x: List[Int]): Int = {
        if (x.isEmpty)
            throw new NoSuchElementException
        if (x.size == 1)
            x.head
        else if (x.head > calcMax(x.tail))
            x.head else calcMax(x.tail)
    }

    // 递归反转字符串
    def reverseStr(x: String): String = {
        if (x.length == 1)
            x
        else
            reverseStr(x.tail) + x.head
    }

    // 递归求阶乘
    def factorial(n: Int): Int =
        if (n == 0) 1 else n * factorial(n -1)

    // 递归求斐波拉契数列
    def fob(n: BigInt): BigInt = {
        if (n ==1 || n == 2)
            1
        else
            fob(n - 1) + fob(n - 2)
    }
}
