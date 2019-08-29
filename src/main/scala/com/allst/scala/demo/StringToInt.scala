package com.allst.scala.demo

/**
  * numeral 的隐式转换
  * @author JUNN
  * @since 2019-08-29 下午 11:36
  */
object StringToInt {

  /**
    * 定义一个隐式转换类
     * @param s
    *          待转换值
    */
  implicit class string2int(s: String) {
    /**
      * 转换成int
      * @param radix
      *              待转换的进制
      * @return
      *         转换结果
      */
    def _2Int(radix: Int) = Integer.parseInt(s, radix)
  }

  /**
    * 期望声明方法会抛出异常
    * @param s
    *          待转换值
    * @throws java.lang.NumberFormatException
    *                                         异常类型
    * @return
    *         转换结果
    */
  @throws(classOf[NumberFormatException])
  def _toInt(s: String) = s.toInt

  def _toInt2(s: String): Option[Int] = {
    try {
      Some(s.toInt)
    } catch {
      case e: NumberFormatException => None
    }
  }

  def main(args: Array[String]): Unit = {
    val a = new string2int("10")._2Int(2)
    println(a)
  }
}
