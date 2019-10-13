package com.allst.scala.demo

/**
  * 特质的自身类型
  * @author YiYa
  * @since 2019-10-13 下午 09:22
  */
object TraitSelfType {
  def main(args: Array[String]): Unit = {

  }
}

// Logger就是自身特质类型, 但这里做了自身类型后就类似等价于
// trait Logger extends Exception, 要求混入该特质的类也是Exception子类
trait Logger {
  // 明确告诉编译器, 我就是Exception, 如果没有这句话, 下面的getMessage就不能调用
  this: Exception => def log(): Unit = {
    println(getMessage)
  }
}

// class Console extends Logger {} // 错误, Console首先得是Exception的子类
class Console extends Exception with Logger {}