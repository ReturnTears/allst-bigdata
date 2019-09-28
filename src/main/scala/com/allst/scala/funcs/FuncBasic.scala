package com.allst.scala.funcs

/**
  * @author YiYa
  * @since 2019-09-28 上午 11:51
  */
object FuncBasic {
  def main(args: Array[String]): Unit = {
    // 类似Java中的调用形式, 先创建对象在调用方法
    val mth = new Method
    println(mth.sumNum(10, 20))

    // 方法转成函数
    val fun2 = mth.sumNum _
    println("fun2类型: " + fun2)
    println("fun2 = " + fun2(10, 20))

    // 函数, 求两个数的和
    val fun = (a: Int, b: Int) => {
      a + b
    }
    println("fun的类型: " + fun)
    println("func = " + fun(10, 20))

    val a = 22
    val b = 11
    println(getSum(a, b, '-'))
  }

  // 定义函数
  def getSum(num1: Int, num2: Int, opr: Char)  = {
    if (opr == '+') {
      num1 + num2
    } else if (opr == '-') {
      num1 - num2
    } else {
      null
    }
  }
}
// Method类, 其中定义方法
class Method {
  def sumNum(a: Int, b: Int): Int = {
    a + b
  }
}