

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
        // 父包用子包中的对象需要使用import
        import com.allst.scala.demo.pkgObj.PkgName
        val pkg2 = new PkgName
        pkg2.play("JUN")
      }
    }

  }
  // 定义一个包, 包名称为pkgObj
  package pkgObj {
    class PkgName {
      val name = "Hello"
      def play(msg: String): Unit = {
        println(this.name + ", " + msg)
        playAge()
      }
    }
  }
  // 在包中直接写方法, 或者变量,就会报错, 可以使用包对象的技术来解决
  // package object pkgObj表示创建一个包对象pkgObj, 它是com.allst.scala.demo.pkgObj这个包对应的包对象
  // 每一个包都可以有一个包对象
  // 包对象的名字需要和子包一致
  // 在包对象中可以定义变量和方法, 可以在包中使用
  package object pkgObj {
    val age: Int = 18
    def playAge(): Unit = {
      println("age = " + age)
    }
  }
}
