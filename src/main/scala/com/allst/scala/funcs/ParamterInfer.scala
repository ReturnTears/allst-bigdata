package com.allst.scala.funcs

/**
  * 参数类型推断
  * 案例小结:
  * 1),map是一个高阶函数, 隐藏也可以直接传入一个匿名函数, 完成map
  * 2),当遍历list时, 参数类型是可以推断出来的, 可以省略数据类型Int, println(list.map((x)=>x+1))
  * 3),当传入的函数只有单个参数时,可以省去括号println(list.map(x => x + 1))
  * 4),如果变量只在=>右边出现一次,可以使用下划线_来代替 println(list.map(_ + 1))
  * 5),
  * @author YiYa
  * @since 2019-11-19 下午 09:29
  */
object ParamterInfer {
    def main(args: Array[String]): Unit = {
        val list = List(12,3,4)
        println(list.map((x: Int) => x + 1))
        // 简写
        println(list.map((x) => x + 1))
        // 再简写
        println(list.map(x => x + 1))
        // 继续简写
        println(list.map(_ + 1))

        // reduce的简写演变
        val result = list.reduce(_ + _)
        println(result)
        val result2 = list.sum
        println(result2)
        // 简写如下:
        println(list.reduce(f1))
        println(list.reduce((n1: Int, n2: Int) => n1 + n2))
        println(list.reduce((n1, n2) => n1 + n2))
        println(list.reduce(_ + _))


    }

    def f1(n1: Int, n2: Int): Int = {
        n1 + n2
    }
}
