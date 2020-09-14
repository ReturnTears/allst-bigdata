package com.allst.scala.flink

import java.sql.{Connection, DriverManager, PreparedStatement}

import org.apache.flink.configuration.Configuration
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction
import org.apache.flink.streaming.api.scala._

/**
  * 将Flink处理后的结果添加到MySQL
  *
  * @author YiYa
  * @since 2020-09-14 下午 10:33
  */
object FlinkStreamSink2JDBC {
    def main(args: Array[String]): Unit = {
        val env = StreamExecutionEnvironment.getExecutionEnvironment
        val inputPath = "E:\\IdeaProjects\\allst-scala\\src\\main\\resources"
        val inputStream = env.readTextFile(inputPath + "\\api.txt")

        val dataStream = inputStream.map(dt => {
            val arr = dt.split(",")
            Music(arr(0), arr(1).toInt, arr(2), arr(3).toLong)
        })

        dataStream.addSink(new MyJDBCSinkFunction)
        env.execute("jdbc sink exec")
    }
}

class MyJDBCSinkFunction() extends RichSinkFunction[Music] {
    var conn: Connection = _
    var insertStmt: PreparedStatement = _
    var updateStmt: PreparedStatement = _
    // 定义连接、预编译语句
    override def open(parameters: Configuration): Unit = {
        conn = DriverManager.getConnection("jdbc:mysql://192.168.2.22:3306/flink", "root", "123456")
        insertStmt = conn.prepareStatement("insert into music (name, age, author, hot) values (?, ?, ?, ?)")
        updateStmt = conn.prepareStatement("update music set hot = ? where name = ?")
    }

    override def invoke(value: Music): Unit = {
        updateStmt.setLong(1, value.hot)
        updateStmt.setString(2, value.name)
        updateStmt.execute()
        if (updateStmt.getUpdateCount == 0) {
            insertStmt.setString(1, value.name)
            insertStmt.setInt(2, value.age)
            insertStmt.setString(3, value.author)
            insertStmt.setLong(4, value.hot)
            insertStmt.execute()
        }
    }

    // 关闭连接
    override def close(): Unit = {
        insertStmt.close()
        updateStmt.close()
        conn.close()
    }
}