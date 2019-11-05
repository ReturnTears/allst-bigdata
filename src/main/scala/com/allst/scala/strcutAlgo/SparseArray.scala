package com.allst.scala.strcutAlgo

import scala.collection.mutable.ArrayBuffer

/**
  * 稀疏数组
  *
  * @author YiYa
  * @since 2019-11-05 下午 11:02
  */
object SparseArray {
  def main(args: Array[String]): Unit = {
    val rowSize = 11
    val colSize = 11
    // 演示一个稀疏数组的使用
    val chessMap = Array.ofDim[Int](rowSize, colSize)
    // 初始化棋盘
    chessMap(1)(2) = 1    // 1表示黑子
    chessMap(2)(3) = 2    // 2表示白子

    // 初始化原始的棋盘
    for (row <- chessMap) {
      for (col <- row) {
        printf("%d\t", col)
      }
      println()
    }

    // 将chessMap转换成稀疏数组
    val sparseArr = ArrayBuffer[Node]()
    val node = new Node(rowSize, colSize, 0)
    sparseArr.append(node)
    for (i <- 0 until chessMap.length) {
      for (j <- 0 until chessMap(i).length) {
        // 判断该值是否为0, 不为0则保存
        if (chessMap(i)(j) != 0) {
          // 构建一个node结构
          val node = new Node(i, j, chessMap(i)(j))
          // 加入到稀疏数组
          sparseArr.append(node)
        }
      }
    }

    // 遍历稀疏数组
    println("-------------------稀疏数组----------------")
    for (node <- sparseArr) {
      printf("%d\t%d\t%d\n", node.row, node.col, node.value)
    }

    // 存盘 相当于原始数组 -> 稀疏数组

    // 读盘 相当于稀疏数组 -> 原始数组

    // 稀疏数组 -> 原始数组

    // 在知道读盘规则的情况下,读取稀疏数组的第一个元素
    val sparseArr2 = sparseArr(0)
    val rowSize2 = sparseArr2.row
    val colSize2 = sparseArr2.col
    val chessMap2 = Array.ofDim[Int](rowSize2, colSize2)
    for (i <- 1 until sparseArr.length) {
      val node = sparseArr(i)
      chessMap2(node.row)(node.col) = node.value
    }

    println("----------------------从稀疏数组恢复后的地图--------------------")
    for (row2 <- chessMap2) {
      for (col2 <- row2) {
        printf("%d\t", col2)
      }
      println()
    }

  }
}

class Node(val row: Int, val col: Int, val value: Int)