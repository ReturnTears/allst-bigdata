package com.allst.scala.funcs

/**
  * 偏函数
  * @author YiYa
  * @since 2019-11-17 下午 10:04
  */
object PartialFunc3 {
    def main(args: Array[String]): Unit = {
        // 方式3: 偏函数
        val list = List(1, 2, 3, 4, 5, "Hi")
        // 使用偏函数不能使用map, 应该使用collect
        val list2 = list.collect(pf)
        println(list2)
    }

    /**
      * 定义一个偏函数
      * 1,PartialFunction[Any, Int]表示偏函数接收的参数类型是Any, 返回类型是Int
      * 2,isDefinedAt(v1: Any)如果返回true, 就会去调用apply方法构建对象实例, 如果是false则过滤
      * apply过滤器,对传入的值+1, 并返回新的集合
      */
    val pf = new PartialFunction[Any, Int] {
        override def isDefinedAt(x: Any): Boolean = x.isInstanceOf[Int]

        override def apply(v1: Any): Int = {
            v1.asInstanceOf[Int] + 1
        }
    }
}
