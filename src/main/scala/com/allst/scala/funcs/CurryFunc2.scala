package com.allst.scala.funcs

/**
  * 函数柯里化实例2
  * @author YiYa
  * @since 2019-11-20 下午 10:26
  */
object CurryFunc2 {
    def main(args: Array[String]): Unit = {
        val str1 = "Hello"
        println(str1.checkEq("HellO")(eq))

        // 简化形式
        str1.checkEq("HELLO")(_.equals(_))
    }

    /**
      * 自定义比较函数
      * @param s1   参数1
      * @param s2   参数2
      * @return     结果
      */
    def eq(s1: String, s2: String): Boolean = {
        s1.equals(s2)
    }

    /**
      * 隐式类
      * @param s    参数
      */
    implicit class TestEq(s: String) {
        def checkEq(ss: String)(f:(String, String) => Boolean): Boolean = {
            f(s.toLowerCase, ss.toLowerCase)
        }
    }
}
