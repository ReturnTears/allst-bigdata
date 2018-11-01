package com.allst.scala.aliscala

import scala.collection.mutable.ArrayBuffer

/**
  * Scala Study -- Array、List
  *
  * @author June
  * @version 0.0.1
  */
object AliScalaArrayList {
  def main(args: Array[String]): Unit = {
    /**
      * 定长数组:用Array申明,有元素类型、有数组长度或者明确的元素个数
      */
    // 定义一个长度为10的数值数组
    val numberArray = new Array[Int](10)
    // 定义一个长度为10的String类型数组
    val strArray = new Array[String](10)
    strArray(0) = "first ele"

    val strArray2 = Array("first", "second", 3)
    //println(strArray2(1))

    /**
      * 变长数组：用ArrayBuffer申明,有元素类型，没有数组长度
      * ++=用于向数组中追加内容，++=右侧可以是任何集合
      */
    // 创建String类型ArrayBuffer数组缓冲
    val strArrayVar = ArrayBuffer[String]()
    // +=意思是在尾部添加元素
    strArrayVar += "Hello"
    // +=后面还可以跟多个元素的集合
    strArrayVar += ("World", "Scala")
    // 追加Array数组
    strArrayVar ++= Array("I`ll", "come", "scala")
    // 追加List
    strArrayVar ++= List("i", "miss", "u")
    // 删除末尾n个元素
    strArrayVar.trimEnd(3)
    // 创建整型数组缓冲
    var intArrayVar = ArrayBuffer(1, 2, 3, 1)
    // 在数组索引为0的位置插入元素6
    intArrayVar.insert(0, 6)
    // 在数组索引为0的位置插入元素7,8,9
    intArrayVar.insert(0, 7, 8, 9)
    // 从索引0开始，删除4个元素
    intArrayVar.remove(0, 4)
    // 转成定长数组
    intArrayVar.toArray.toBuffer
    // 将定长数组转成ArrayBuffer,将结果集res.toBuffer
    //intArrayVar.toBuffer

    /**
      * 数组的遍历
      * 两个for在一块使用，不加{}，容易造成循环的嵌套
      */
    for (i <- 0 to intArrayVar.length - 1) {
//        println(intArrayVar(i))
    }
    for (j <- 0 until intArrayVar.length) {
//      println(intArrayVar(j))
    }
    // 数组推荐使用方式
    for (i <- intArrayVar) {
//      println(i)
    }
    // 步长为2
    for (i <- 0 until(intArrayVar.length, 2)) {
//      println(intArrayVar(i))
    }
    // 倒序输出
    for (i <- (0 until intArrayVar.length).reverse) {
//      println(intArrayVar(i))
    }

    /**
      * 数组转换
      * 生成新的数组，原数组不变
      * 缓冲数据转换后产生的仍然是缓冲数组
      * 定长数组转转后产生的仍然是定长数组，原数组不变
      */
    var intArrayVar2 = for (i <- intArrayVar) yield  i * 2
    for (j <- intArrayVar2) {
//      println(j)
    }
    var intArrayNoBuffer = Array(1,2,3,4)
    var intArrayNoBuffer2 = for (j <- intArrayNoBuffer) yield j * 2.5
    // 加过滤条件
    var intArrayNoBuffer3 = for (j <- intArrayNoBuffer2 if j > 8) yield j * 2

    /**
      *  数组操作中的常用算法
      */
    // 定义一个数组
    var intArr = Array(1,2,3,4,5,6,7,8,9)
    // 求和sum
//    println(intArr.sum)
    // 求最大值
//    println(intArr.max)
    // 最小值
    intArr.min
    // toString()方法
    intArr.toString
    // mkString()方法
    intArr.mkString(",")
    intArr.mkString("<",",",">")

    /**
      *  多维数组
      *  通过数组的数组实现多维数组的定义
      */
    var multiDimArr = Array(Array(1,2,3), Array(4,5,6))
    // 获取第一行第三列的元素
//    println(multiDimArr(0)(2))
    // 多维数组的遍历
    for (i <- multiDimArr) {
//      println(i.mkString(","))
    }

    /**
      * 列表list操作实战
      *  List类型定义及List的特点
      */
    val fruit = List("apple", "banana", "orange")
    // 上句等同于下句
    var fruit_ = List.apply("apple", "banana", "orange")
    // 数值类型List
    val nums = List(1,2,3,4,5)
    // 多重List:List的子元素为List
    val diagMatrix = List(List(1,2,3),List(4,5,6),List(7,8,9))
    // 遍历List
    for (i <- diagMatrix) {
//      println(i)
    }

    /**
      * List常用构造方法
      * 采用::及Nil进行列表构建
      * 由于::操作符的优先级是从右往左的，因此上一条语句等同于下面这条语句
      */
    val numbs = 1 :: (2 :: (3 :: (4 :: Nil)))
    // 上句等同于
    val numss = 1 :: 2 :: 3 :: 4 ::Nil
//    println(numss)

    /**
      * List常用操作
      */
    // 判断是否为空
    if(numss.isEmpty) println("yes") else println("no")
    // 取第一个元素
    println("first ele is : "+numss.head)
    // 取出第一个元素外剩余的元素，返回的是列表
    println(numss.tail)
    // 插入排序算法实现
    def isort(xs: List[Int]): List[Int] =
      if (xs.isEmpty) Nil else insert(xs.head, isort(xs.tail))
    def insert(x: Int, xs: List[Int]): List[Int] =
      if (xs.isEmpty || x <= xs.head) x :: xs else xs.head :: insert(x, xs.tail)

    // List链接操作
    List(1,2,3) ::: List(4,5,6)
    // 取除最后一个元素外的元素，返回的是列表
    numss.init
    // 取除最后一个元素
    numss.last
    // 列表元素倒置
    numss.reverse
    // 一些好玩的方法调用
    numss.reverse.reverse==numss
    numss.reverse.init
    numss.tail.reverse
    // 丢弃前n个元素
    numss drop 3
    // 获取前n个元素
    numss take(1)
    // 将列表进行分割
    numss.splitAt(2)
    // 上句等同下句
    (numss.take(2),numss.drop(2))
    // zip操作
    val numa = List(1,2,3,4,5,6)
    val chars = List('1','2','3','4','5','6')
    // 返回的是List类型的元组(Tuple）
    numa zip chars
    // List toString方法
    numa.toString
    // List mkString方法
    numa.mkString
    // 转换成数组
    numa.toArray

    /**
      * List伴生对象方法
      * range方法含首不含尾
      */
    // apply方法
    List.apply(1,2,3,4)
    // range方法,构建某一值范围内的List
    List.range(2,6)
    // 步长:2
    List.range(2,6,2)
    // 步长:-1
    List.range(2,6,-1)
    // 构建相同元素的List
//todo    List.make(5, "key")
    // unzip方法
//todo    List.unzip(res145)
    // list.flatten，将列表平滑成第一个无素
    val xss = List(List('a', 'b'), List('c'), List('d', 'e'))
    xss.flatten
    // 列表链接
    List.concat(List('a', 'b'), List('c'))
    // 上句等同于下句
    List('a', 'b') ::: List('c')
  }
}
