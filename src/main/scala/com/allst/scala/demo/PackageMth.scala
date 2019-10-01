

/**
  * @author YiYa
  * @since 2019-10-01 下午 10:49
  */
// package com.allst.scala.demo {} 表示创建了包com.allst.scala.demo, 在{}中我们还要继续写他的子包pkg,
// com.allst.scala.demo.pkg, 还可以写类, 特质trait, 还可以写object
// 综上所述: Scala中支持在一个文件中,可以同时创建多个包,以及给各个包创建类,trait和object
package com.allst.scala.demo {

  package pkg {

    class PackageMth {
      val name = "JULY"
      def play(message: String): Unit = {
        println(this.name + " , " + message)
      }
    }

    object test {
      def main(args: Array[String]): Unit = {
        val pkg = new PackageMth
        pkg.play("Hello!")
      }
    }

  }
}
