# Flink

## Flink 简介
\color{red}Flink是什么?
```text
Apache Flink是一个框架和分布式处理引擎, 用于对无界和有界数据流进行状态计算。

Flink应用场景很广泛

\color{red}为什么选择Flink?
·流数据更真实地反应了我们的生活方式
·传统的数据架构是基于有限数据集
·我们需要的目标:
 低延迟
 高吞吐
 结果的准确性和良好的容错性

那些行业需要处理流数据?
电商和市场营销 >> 数据报表、广告投放、业务流程需要
物联网(IOT) >> 传感器实时数据采集和显示、实时报警、交通运输业
电信业 >> 基站流量调配
银行和金融业 >> 实时结算和通知推送、实时检测异常行为

传统数据处理架构
前端事件操作产生数据 >> Transactional DBMS
事务处理

分析处理
Transactional DBMS >> ETL Process >> Data Warehouse >> Reports or Ad-HocQueries
将数据从业务数据库复制到数仓,再进行分析和查询

有状态的流式处理
一个一个数据点(形成数据流) >> 应用逻辑 >> 本地状态(方便故障恢复 > periodic checkpoint) >> Remote Storage

流处理的演变
用两套系统,同时保证低延迟和结果准确
Event Log >> Batch Layer(Event Importer > Batch Storage > Batch Processor) 保证了准确性
             or
             Speed Layer(Stream Processor)
          >> Serving Layer (Batch Table and Speed Table) 保证了实时性 
          >> -- (query and merge results) 合并结果 -- >> Application
低延迟: Storm (第一代流处理框架)
高吞吐: Spark Streaming (第二代流处理框架), 还是按照批次来处理数据流的
Flink (第三代流处理框架)

Flink的主要特点
1、事件驱动(Event-driver)
2、在Flink的世界观里面，一切都是流组成的，离线数据是有界的流，实时数据是一个没有界限的流，这就是所谓的有界流和无界流 
  有界流: bounded stream
  无界流: unbounded stream
  批处理就是特殊的流处理
3、分层API
  越顶层越抽象，表达含义越简明，使用越方便
  越底层越具体，表达能力越丰富，使用越灵活
  High Level Analytics API (SQL / Table API(dynamic tables))
  Stream & Batch Data Processing (DataStream API (streams, windows))
  Stateful Event - Driven Applications (ProcessFunction (events, state,time))
4、支持事件时间(event-time) 和处理时间(processing-time)语义
5、精确一次（exactly-once）的状态一致性保证
6、低延迟，高吞吐，每秒处理百万个事件、毫秒级延迟
7、与众多常用存储系统进行连接
8、高可用，动态扩展，实现7*24小时全天候运行

Flink VS Spark Streaming
流和微批
数据模型
    spark采用的RDD模型，Spark Streaming的DStream实际上也就是一组组小批数据RDD的集合
    flink基本数据模型是数据流，以及事件序列
运行时架构
    spark是批计算，将DAG划分为不同的stage，一个完成后才可以计算下一个
    flink是标准的流执行模式，一个事件在一个节点处理完成后可以直接法网下一个节点进行处理
```

##  Flink jar
```text
<!-- Flink依赖（Java） -->
    <dependency>
      <groupId>org.apache.flink</groupId>
      <artifactId>flink-java</artifactId>
      <version>1.10.1</version>
      <scope>provided</scope>
    </dependency>
    <dependency>
      <groupId>org.apache.flink</groupId>
      <artifactId>flink-streaming-java_2.12</artifactId>
      <version>1.10.1</version>
      <scope>provided</scope>
    </dependency>
    <!-- Flink依赖（Scala） -->
    <dependency>
      <groupId>org.apache.flink</groupId>
      <artifactId>flink-scala_2.12</artifactId>
      <version>1.10.1</version>
      <scope>provided</scope>
    </dependency>
    <dependency>
      <groupId>org.apache.flink</groupId>
      <artifactId>flink-streaming-scala_2.12</artifactId>
      <version>1.10.1</version>
      <scope>provided</scope>
    </dependency>
```
