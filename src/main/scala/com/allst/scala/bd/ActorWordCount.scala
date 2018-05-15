package com.allst.scala.bd

import scala.collection.mutable.ListBuffer
import scala.concurrent.Future

/**
  * WordCount
  * @author June
  */
object ActorWordCount {

  def main(args: Array[String]): Unit = {
    val futures = new ListBuffer[Future[Any]]
    val results = new ListBuffer[Map[String, Int]]
  }

}

case class Submit(filePath: String)

case object Stop

//class Task extends Actor {
//
//}