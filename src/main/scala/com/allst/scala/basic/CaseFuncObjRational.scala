package com.allst.scala.basic

/**
  * case开头的表示案例文件
  *
  * @author YiYa
  * @since 2020/7/1-16:12
  */
object CaseFuncObjRational extends App {
  // 隐式转换
  implicit def intToRetional(x: Int) = new Retional(x)

  val rs = new Retional(66, 42)
  println(rs)

  var x = new Retional(1, 2)
  var y = new Retional(2, 3)
  println(x.+(y))
}

/**
  * 如果类没有主体就不需要指定一对花括号，括号里的参数被称为类参数class parameter
  *
  * @param n 类参数1
  * @param d 类参数2
  */
class Retional(n: Int, d: Int) {
  require(d != 0)
  // 定义私有字段
  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g

  // 定义辅助构造器
  def this(n: Int) = this(n, 1)

  // 定义 + * 方法
  def +(that: Retional): Retional =
    new Retional(numer * that.denom + that.numer * denom, denom * that.denom)

  def *(that: Retional): Retional =
    new Retional(numer * that.numer, denom * that.denom)

  override def toString: String = numer + " / " + denom

  def add(that: Retional): Retional =
    new Retional(numer * that.denom + that.numer * denom, denom * that.denom)

  // 定义私有方法
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  // 方法重载
  def +(i: Int): Retional = new Retional(numer + i * denom, denom)

  def -(that: Retional): Retional =
    new Retional(numer * that.denom - that.numer * denom, denom * that.denom)

  def -(i: Int): Retional = new Retional(numer - i * denom, denom)

  def *(i: Int): Retional = new Retional(numer * i, denom)

  def /(that: Retional): Retional = new Retional(numer * that.denom, denom * that.numer)

  def /(i: Int): Retional = new Retional(numer, denom * i)
}