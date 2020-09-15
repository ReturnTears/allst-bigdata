package com.allst.scala.flink

import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.connectors.redis.RedisSink
import org.apache.flink.streaming.connectors.redis.common.config.FlinkJedisPoolConfig
import org.apache.flink.streaming.connectors.redis.common.mapper.{RedisCommand, RedisCommandDescription, RedisMapper}

/**
  * 将Flink处理后的结果添加到Redis
  *
  * @author YiYa
  * @since 2020-09-14 下午 09:40
  */
object FlinkStreamSink2Redis {
    def main(args: Array[String]): Unit = {
        val env = StreamExecutionEnvironment.getExecutionEnvironment
        val inputPath = "E:\\Projects\\IdeaProjects\\allst-scala\\src\\main\\resources"
        //val inputPath = "E:\\IdeaProjects\\allst-scala\\src\\main\\resources"
        val inputStream = env.readTextFile(inputPath + "\\api.txt")

        val dataStream = inputStream.map(dt => {
            val arr = dt.split(",")
            Music(arr(0), arr(1).toInt, arr(2), arr(3).toLong)
        })

        val conf = new FlinkJedisPoolConfig.Builder()
          .setHost("192.168.2.22")
          .setPort(6379)
          .build()
        dataStream.addSink(new RedisSink[Music](conf, new MyRedisMapper))

        env.execute("redis sink exec")
    }
}
class MyRedisMapper extends RedisMapper[Music] {

    override def getCommandDescription: RedisCommandDescription =
        new RedisCommandDescription(RedisCommand.HSET, "music_hot")

    override def getKeyFromData(t: Music): String = t.hot.toString

    override def getValueFromData(t: Music): String = t.name
}