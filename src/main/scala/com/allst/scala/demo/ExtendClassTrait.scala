package com.allst.scala.demo

/**
  * 扩展类特质
  * @author YiYa
  * @since 2019-10-13 下午 09:01
  */
object ExtendClassTrait {
  def main(args: Array[String]): Unit = {

  }
}

/**
  * LoggedException继承了Exception, 这时该特质可以使用Exception的功能
  *
  */
trait LoggedException extends Exception {
  def log(): Unit = {
    println(getMessage())   // 方法来自于Exception类
  }
}

/**
  * 所有混入该特质的类会自动成为那个特质所继承的超类的子类
  * 即:UnhappyException继承了LoggedException, 而LoggedException继承了Exception
  * 那么UnhappyException就成为了Exception的子类
  *
  * 所有可以重写其方法
  */
class UnhappyException extends LoggedException {
  override def getMessage: String = "error!"
}

/**
  * 如果混入该特质的类, 已经继承了另一个类(A类), 则要求A类是特质超类的子类, 否则会出现多继承现象,发送错误
  */
class UnHappyException2 extends IndexOutOfBoundsException with LoggedException {
  override def getMessage: String = "error exception2 !"
}