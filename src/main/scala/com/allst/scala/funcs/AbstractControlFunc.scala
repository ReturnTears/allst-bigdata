package com.allst.scala.funcs

/**
  * 抽象控制函数
  * @author YiYa
  * @since 2019-11-20 下午 10:44
  */
object AbstractControlFunc {
    def main(args: Array[String]): Unit = {
        myRun {
            () =>
              // 相当于下面的代码块替换了f1()
                println("work doing, five seconds finish")
                Thread.sleep(5000)
                println("work done")
        }

        myRun2 {
            println("work doing, three seconds finish 😀")
            Thread.sleep(3000)
            println("work done 😀")
        }
    }

    /**
      * 抽象控制
      * @param f1   函数参数
      */
    def myRun(f1: () => Unit) = {
        new Thread() {
            override def run(): Unit = {
                f1()
            }
        }.start()
    }

    /**
      * 抽象控制写法2
      * @param f1 函数参数
      */
    def myRun2(f1: => Unit) = {
        new Thread() {
            override def run(): Unit = {
                f1
            }
        }.start()
    }

}
