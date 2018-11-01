package com.allst.scala.xml

import java.io.File

import scala.io.Source
import scala.xml.XML

/**
  * Scala从xml中提取数据写入本地文本中
  *
  * @author June
  * @version 1.0
  */
object ScalaExtractDataFromXml {

  def main(args: Array[String]): Unit = {
    val file = new File("E:\\dxmro\\dxmroztea\\0to1\\FDD-LTE_MRO_ZTE_OMC1_55581_20180627000000.xml");


  }


  /**
    * 读取文件到内存
    * @param file
    */
  def readFileToMemory(file: File): Unit = {
    val someXml = XML.loadFile(file)
  }

  /**
    * 指定文件路径读取文件到内存
    * @param strFile
    */
  def readStrToMemory(strFile : String): Unit = {
    val xmlPath = XML.loadFile("E:\\dxmro\\dxmroztea\\0to1\\FDD-LTE_MRO_ZTE_OMC1_55581_20180627000000.xml")
//    val xmlInfo = Source.fromFile(xmlPath)
//    xmlInfo.foreach {
//      print()
//    }

//    val xmlFile = XML.load()
//    println(xmlFile)
//    val fromUserName = (xmlFile\"FromUserName").text.toString.trim()
//    println("fromUserName:"+fromUserName)
  }
}
