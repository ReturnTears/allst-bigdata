package com.allst.scala.flink

import com.allst.scala.comm_use.TransformType
import com.allst.scala.comm_use.TransformType.TransformType

/**
  * FLink转换数据:
  * 场景介绍:
  * 本地环境不同链接下的数据库,将数据库A中的table1中的部分字段的数据复制到数据库B中table2中
  * 简言之，复制不同链接数据库表的部分数据
  *
  * 解决思路:
  * 将数据库A中的table导出为文件，再由Flink stream source api 转换写入到MySQL
  *
  * ps：这样做的原因是最近在学习flink，故借此机会操作该方法😊(●'◡'●)
  *
  * @author YiYa
  * @since 2020/9/15-11:55
  */
object FlinkStreamTransData {
  def main(args: Array[String]): Unit = {
    transData1toData2(TransformType.DeleteAndTransform)
  }

  /**
    * 数据表1写入到数据表2的三种情况:
    *   -1 先删除数据表2原有数据后再导入
    *    0 直接导入
    *    1 合并数据后再导入
    */
  def transData1toData2(trans: TransformType): Unit = {
    println(trans)
  }
}

/**
  * table2中参数样例类
  */
case class BaseParams(id: String,
                      paramName: String,
                      paramCode: String,
                      paramSort: Int,
                      paramState: String,
                      dictId: String,
                      itemId: String,
                      parentId: String,
                      parentIds: String)

/**
  * table1中参数样例类
  */
case class  Params(id: String,
                   name: String,
                   code: String,
                   sort: Int,
                   status: String,
                   dictId: String,
                   itemId: String,
                   parentId: String,
                   parentIds: String
                  )