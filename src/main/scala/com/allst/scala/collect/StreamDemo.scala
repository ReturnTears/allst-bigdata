package com.allst.scala.collect

/**
  * 流Stream
  * @author YiYa
  * @since 2019-11-03 下午 04:42
  */
object StreamDemo {
  def main(args: Array[String]): Unit = {
    // 创建Stream
    def numsForm(n: BigInt): Stream[BigInt] = n #:: numsForm(n + 1)
    val stream1 = numsForm(7)
    println(stream1)

    // 取第一个元素
    println("head = " + stream1.head)

    // 取最后一个元素
    println("tail = " + stream1.tail)

    println(stream1)

    def numsStream(n: BigInt): Stream[BigInt] = n #:: numsStream(n + 7)
    // 将流放到map函数中进行遍历计算
    def num2(x: BigInt): BigInt = {
      x * x
    }
    val stream2 = numsStream(2).tail
    println(numsStream(7).map(num2))

  }
}
