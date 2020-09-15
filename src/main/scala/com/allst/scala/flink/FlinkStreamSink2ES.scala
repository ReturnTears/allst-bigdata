package com.allst.scala.flink

import java.util

import org.apache.flink.api.common.functions.RuntimeContext
import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.connectors.elasticsearch.{ElasticsearchSinkFunction, RequestIndexer}
import org.apache.flink.streaming.connectors.elasticsearch6.ElasticsearchSink
import org.apache.http.HttpHost
import org.elasticsearch.client.Requests

/**
  * 将Flink处理后的结果添加到ElasticSearch
  *
  * 启动es
  * @author YiYa
  * @since 2020-09-14 下午 09:06
  */
object FlinkStreamSink2ES {
    def main(args: Array[String]): Unit = {
        val env = StreamExecutionEnvironment.getExecutionEnvironment
        val inputPath = "E:\\Projects\\IdeaProjects\\allst-scala\\src\\main\\resources"
        //val inputPath = "E:\\IdeaProjects\\allst-scala\\src\\main\\resources"
        val inputStream = env.readTextFile(inputPath + "\\api.txt")

        val dataStream = inputStream.map(dt => {
            val arr = dt.split(",")
            Music(arr(0), arr(1).toInt, arr(2), arr(3).toLong)
        })

        val httpHosts = new util.ArrayList[HttpHost]()
        httpHosts.add(new HttpHost("192.168.2.22", 9200))

        val myEsSinkFunc = new ElasticsearchSinkFunction[Music] {
            override def process(t: Music, runtimeContext: RuntimeContext, requestIndexer: RequestIndexer): Unit = {
                // 包装一个Map作为Data Source
                val dataSource = new util.HashMap[String, String]()
                dataSource.put("name", t.name)
                dataSource.put("age", t.age.toString)
                dataSource.put("author", t.author)
                dataSource.put("got", t.hot.toString)

                // 创建index request， 用于发送http请求
                val indexRequest = Requests.indexRequest()
                  .index("music")
                  .`type`("musicDt")
                  .source(dataSource)

                // 用indexer发送请求
                requestIndexer.add(indexRequest)
            }
        }

        dataStream.addSink(new ElasticsearchSink.Builder[Music](httpHosts, myEsSinkFunc).build())

        env.execute("es sink exec")
    }
}
