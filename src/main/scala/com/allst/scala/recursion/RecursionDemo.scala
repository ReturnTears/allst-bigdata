package com.allst.scala.recursion

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Date

/**
  * 使用递归的方式去思考, 去编程
  *
  * @author YiYa
  * @since 2019-11-21 下午 10:16
  */
object RecursionDemo {
    def main(args: Array[String]): Unit = {
        calcSum()   //248
        calcMx()    // 45
    }

    // 计算1~50的和, 使用常规的while来完成
    def calcSum(): Unit = {
        //val now: LocalDate = new LocalDate()
        val now2: Date = new Date()
        val dateFormat: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val date = dateFormat.format(now2)
        val curr1 = System.currentTimeMillis()
        println(curr1)

        var res = BigInt(0)
        var num = BigInt(1)
        var maxVal = BigInt(99999)

        while (num <= maxVal) {
            res += num
            num += 1
        }

        println(res)

        val curr2 = System.currentTimeMillis()
        println(curr2 - curr1)

    }

    def calcMx(): Unit = {
        val curr = System.currentTimeMillis()
        mx(1, 0)
        val curr2 = System.currentTimeMillis()
        println(curr2 - curr)
    }
    // 递归计算前n个数的和
    def mx(num: BigInt, sum: BigInt): BigInt = {
        if (num <= 99999L)
            mx(num + 1, sum + num)
        else
            sum
    }
}
