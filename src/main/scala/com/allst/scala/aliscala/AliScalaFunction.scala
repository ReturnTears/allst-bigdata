package com.allst.scala.aliscala

/**
  * 函数与闭包
  * Created by June on 2018-05-24
  */
object AliScalaFunction {

  def main(args: Array[String]): Unit = {
    /**
      * 函数字面量（值函数）
      * 函数字面量（function literal），也称值函数（function values），指的是函数可以赋值给变量。
      * =>左侧表示输入，右侧表示转换操作
      */
    val increase = (x: Int) => x + 1
    // 等同于
    def incre(x: Int) = x + 1
    // 多语句则使用
    val MoreIncre = (x: Int) => {
      println("i")
      println("love")
      println("you")
      x + 1
    }
    // 数组的map方法中调用(写法1)
    println(Array(1,2,3,4).map(increase).mkString(","))
    // 匿名函数（写法2）
    println(Array(1,2,3,4).map((x: Int) => x + 1).mkString(","))
    // 函数进一步简化(写法3)
    Array(1,2,3,4).map{(x: Int) => x + 1}.mkString(",")
    // 省略.的方式(写法4)
    Array(1,2,3,4) map{(x: Int) => x + 1} mkString(",")
    // 参数类型判断写法(写法5)
    Array(1,2,3,4) map{(x) => x + 1} mkString(",")
    // 函数只有一个参数的话，可以省略()（写法6）
    Array(1,2,3,4) map{x => x + 1} mkString(",")
    // /如果参数右边只出现一次，则可以进一步简化（写法7）
    Array(1,2,3,4) map(_ + 1) mkString(",")

    // 值函数简化方式
    val func = 1 + (_: Double)
    func(2)
    val func2: (Double) => Double= 1+_

    // 函数参数(高阶函数) ((Int)=>String)=>String
    def converIntToString(f: (Int) => String) = f(4)
    converIntToString((x: Int) => x + "s")

    // 高阶函数可以产生新的函数 (Double)=>((Double)=>Double)
    def multiplyBy(factor:Double) = (x: Double) =>factor * x
    val x = multiplyBy(10)
    x(20) // 200.0

    // 函数闭包(closure) (x:Int)=>x+more,more是一个自由变量(free variable),more是一个没有给定含义的不定变量
    // 而x则类型确定、值在函数调用的时候被赋值，称这种变量为绑定变量（Bound Variable）
//    (x: Int) => x + more
    var more = 1
    val fun = (x: Int) => x + more
    fun(10)
    // 像这种运行时确定more类型及值的函数称为闭包,more是个自由变量，在运行时其值和类型得以确定
    val someNumber = List(-11, -10, -5, 0, 5, 10)
    var sum = 0
    someNumber.foreach(sum += _)
    // 下列函数也是一种闭包，因为在运行时其值才得以确定
    def multiplyBy2(factor:Double)=(x:Double)=>factor*x
  }
}
