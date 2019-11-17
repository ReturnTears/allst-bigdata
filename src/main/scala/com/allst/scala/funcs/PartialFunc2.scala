package com.allst.scala.funcs

/**
  * 偏函数(同PartialFunc1)
  * 对比方式1, 方式1太麻烦
  * @author YiYa
  * @since 2019-11-17 下午 09:58
  */
object PartialFunc2 {
    def main(args: Array[String]): Unit = {
        // 方式2: 采用模式匹配, 有小瑕疵, 不够完美
        val list = List(1, 2, 3, 4, 5, "Scala")
        val list2 = list.map(addOne)
        println(list2)
    }

    def addOne(n: Any): Any = {
        n match {
            case x: Int => x + 1
            case  _ =>
        }
    }
}
