package com.allst.scala.funcs

/**
  * 闭包案例1
  * @author YiYa
  * @since 2019-11-19 下午 10:02
  */
object ClosureFunc1 {
    def main(args: Array[String]): Unit = {
        // 这里f函数就是闭包
        val f = minusXy(10)
        println(f(1))

        // 测试闭包函数
        val su = makeSuffix(".png")
        println(su("pic1"))
        println(su("pic2.png"))
    }

    /**
      * 匿名函数(y: Int) => x - y和外部的变量x组成了一个闭包
      * @param x    外部变量x
      * @return     结果
      */
    def minusXy(x: Int) = (y: Int) => x - y

    /**
      * 闭包函数为文件名添加后缀
      * @param suffix   后缀字符串
      */
    def makeSuffix(suffix: String) = {
        (fileName: String) => {
            if (fileName.endsWith(suffix)) fileName else fileName + suffix
        }
    }
}
