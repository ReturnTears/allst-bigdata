package com.allst.scala.funcs

/**
  * 偏函数
  *
  * 案例需求: 给定一个集合要求将几何中所有数字元素+1,返回新的集合并忽略掉非数字元素
  * @author YiYa
  * @since 2019-11-17 下午 09:48
  */
object PartialFunc1 {
    def main(args: Array[String]): Unit = {
        // 方式1: 先filter在map
        val list = List(1, 2, 3, 4, 5, "abc")
        val list2 = list.filter(f1).map(f2).map(f3)
        println(list2)
    }

    /**
      * 判断参数类型
      * @param n    参数
      * @return     返回
      */
    def f1(n: Any): Boolean = {
        n.isInstanceOf[Int]
    }

    /**
      * 转化参数类型Any => Int
      * @param n    参数
      * @return     返回
      */
    def f2(n: Any): Int = {
        n.asInstanceOf[Int]
    }

    /**
      * 元素运算
      * @param n    参数
      * @return     返回
      */
    def f3(n: Int): Int = {
        n + 1
    }
}
