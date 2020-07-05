package com.allst.scala.basic

import java.io.{FileNotFoundException, FileReader, IOException}
import java.net.MalformedURLException

import scala.sys.process.processInternal.URL
/**
  * 抛出异常
  *
  * @author YiYa
  * @since 2020-07-05 下午 10:42
  */
object ScalaInlayException {
    def main(args: Array[String]): Unit = {
        mthTry()
    }
    def mthTry(): Unit = {
        val n = 1
        val half =
            if (n % 2 == 0)
                n / 2
            else
                throw new RuntimeException("n must be even.")
        println(n)
    }

    def phException(): Unit = {
        try {
            val f = new FileReader("input.txt")
            println(f.read())
            f.close()
        } catch {
            case ex: FileNotFoundException => println("File Not Found")
            case ex: IOException => println("IOException")
        }
    }

    def phFinally(): Unit = {
        val file = new FileReader("input.txt")
        try {
            //
            println(file.read())
        } finally {
            file.close()
        }
    }

    def ph(path: String): Unit = {
        try {
            new URL(path)
        } catch {
            case e: MalformedURLException =>
                new URL("http://www.scala-lang.org")
        }
    }
}
