package com.allst.scala.demo

/**
  * 单机版的Scala
  * @author June
  */
object FirstScala {
  def main(args: Array[String]): Unit = {
    println("Hello Scala!")
    // 单机版的WordCount
    val words = List("I miss you yangyang","xiaohu i love you","yangyang i like you","Do you know")
    val res = words.flatMap(_.split(" ")).map((_, 1)).groupBy(_._1).mapValues(_.foldLeft(0)(_+_._2))
    println("方法1输出结果：" + res)
    val ares = words.flatMap(_.split(" ")).map((_, 1)).groupBy(_._1).map(x => (x._1, x._2.size)).toList.sortBy(_._2).reverse
    println("方法2输出结果：" + ares)
    // 写一点Java相关
    // 2018/04/17
    /**
      * 注意:参数类型必须声明，返回值类型可以不声明，函数是递归的必须声明返回类型
      * @param x
      * @return
      */
    def fun(x:Int) : Int = x + 1
    println(fun(5))
    val x = basic(11)
    println(x)

    val per = new Person
    // 修改属性值 var可以被修改（val修饰的只有get方法，var有get、set方法）
    per.name = "July";
    println(per.id + " " + per.name)
    // 访问方法
    println(per.printPop)
  }

  /**
    * 定义一个方法
    * @param n
    * @return
    */
  def basic(n : Int): Int = {
    val a, b = 10
    if (n <= a) 1 else n * basic(n - 1)
//    a.+(b)
  }
}

/**
  *定义scala的类，class的名称和object的名称一致称为伴生对象
  * private[scala]表示包访问权限
  */
private[scala] class Person {
  val id = "9527"
  var name = "June"
  // private表示在这个class里面是独有的，只能在伴生对象里用，同包下的其他类不能访问private修饰的属性
  private var gender: String = "man"
  // 只有在当前class里可用
  private[this] var pop: String = _

  // 定义方法 private
  def printPop: Unit = {
    println(pop)
  }
}
