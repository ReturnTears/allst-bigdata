package com.allst.scala.funcs

/**
  * 偏函数简写形式, 简化PartialFunc3
  * @author YiYa
  * @since 2019-11-18 下午 10:10
  */
object PartialFunc4 {
    def main(args: Array[String]): Unit = {
        val list = List(1, 2, 3.7, 4.4, 5, "Hi")
        val list2 = list.collect(pf)
        println(list2)

        // 第二种简写方式
        val list3 = list.collect{
            case i: Int => i + 1
            case i: Double => i.toInt
        }
        println(list3)
    }

    def pf: PartialFunction[Any, Int] = {
        case i: Int => i + 1
        case i: Double => (i * 10).toInt
    }
}
