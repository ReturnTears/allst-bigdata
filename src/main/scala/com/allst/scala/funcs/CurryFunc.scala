package com.allst.scala.funcs

/**
  * 柯里化函数
  * @author YiYa
  * @since 2019-11-20 下午 10:19
  */
object CurryFunc {
    def main(args: Array[String]): Unit = {
        println(mul(3, 7))
        println(mulCurry1(3)(8))
        println(mulCurry2(3)(9))
    }

    /**
      * 常规方式
      * @param x    参数1
      * @param y    参数2
      * @return     结果
      */
    def mul(x: Int, y: Int) = x * y

    /**
      * 柯里化方式1
      * @param x    参数
      * @return     结果
      */
    def mulCurry1(x: Int) = (y: Int) => x * y

    /**
      * 柯里化方式2
      * @param x    参数1
      * @param y    参数2
      * @return     结果
      */
    def mulCurry2(x: Int)(y: Int) = x * y
}
