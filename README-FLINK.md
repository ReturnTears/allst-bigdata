# Flink

## Flink 简介
```text
Flink是什么?
Apache Flink是一个框架和分布式处理引擎, 用于对无界和有界数据流进行状态计算。

Flink应用场景很广泛

为什么选择Flink?
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

Flink命令行提交作业:
./bin/flink run -c xxx.*.xxx（指定提交的类） -p 2 （并行度） /xxx/xxx/*.jar --host master --port 1234
Flink命令行取消作业提交:
./bin/flink cancel JobId （job id）
Flink命令行查看正在运行的作业
./bin/flink list
Flink命令行查看所有的作业
./bin/flink list -a

Flink命令行启动flink集群
./bin/start-cluster.sh
Flink命令行停止flink集群
./bin/stop-cluster.sh

Yarn模式部署Flink
Flink on Yarn
Flink提供了两种在yarn上运行的模式， 分别为session-cluster和per-job-cluster模式
session-cluster模式:
    session-cluster模式需要先启动集群， 然后再提交作业， 接着会向yarn申请一块空间后， 资源永远保持不变。
  如果资源满了， 下一个作业就无法提交，只能等到yarn中的其中一个作业执行完成后，释放了资源， 下个作业才会正常提交。
  所有作业共享Dispatcher和ResourceManager，共享资源， 适合规模小执行时间短的作业。
  在yarn中初始化一个flink集群，开辟指定的资源， 以提交作业都向这里提交。这个flink集群会常驻yarn莫群中，除非手工停止。
session-cluster模式启动过程:
1、启动Hadoop集群
2、./bin/yarn-seesion.sh -n 2 -s 2 -jm 1024 -tm 1024 -nm test -d
    -n 表示taskmanager数量
    -s 表示taskmanager的slot数量， 默认一个slot一个core
    -jm 表示Jobmanager的内存， MB
    -tm 表示每个taskmanager的内存， MB
    -nm 表示yarn的appName
    -d 表示后台执行
3、提交任务， 同 >> Flink命令行提交作业
4、可以去yarn控制台查看任务状态
5、取消yarn-session
    yarn application --kill id （这里的id是yarn上web ui前端上运行任务的id）

per-job-cluster模式:
    一个job会对应一个集群， 每提交一个作业会根据自身的情况都会单独向yarn申请资源，直到作业执行完成。一个作业的完成
  并不影响下一个作业的正常提交和运行。独向Dispatcher和ResourceManager， 按需解释资源申请，适合规模大，运行时间长的作业。
  每次提交都会常见一个新的flink集群，任务之间相互独立，互不影响，方便管理。任务执行完成之后创建的集群也会消失。

per-job-cluster模式启动流程：
1、启动Hadoop集群
2、不启动yarn-session, 直接执行job
./bin/flink run -m yarn-cluster -c xxx (执行程序的类) xxx.jar --host master --port 1234
重点：-m yarn-cluster
```

## Flink 运行架构
```text
😊😊😊 Flink运行时的组件
o(*￣▽￣*)ブ JobManager
作业管理器:
1、控制一个应用程序执行的主进程，也就是说，每个应用程序都会被一个不同的JobManager所控制执行
2、JobManager会先接收到要执行的应用程序，这个应用程序会包括：
    作业图(JobGraph)、
    逻数据流图(logical dataflow graph)
    和打包了所有的类、库和其他资源的jar包。
3、JobManager会把JobGraph转换成一个物理层面的数据流图，这个图被叫做“执行图”(ExecutionGraph), 包含了所有可以并发执行的任务。
4、JobManager会向资源管理器(ResourceManager)请求执行任务必要的资源， 也就是任务管理(TaskManager)上的插槽(slot)。
    一旦它获取到了足够的资源，就会将执行图分发到真正执行他们的TaskManager上， 而在运行过程中， 
    JobManager会负责所有需要中央协调的操作，，比如说检查点checkpoint的协调。

o(*￣▽￣*)ブ TaskManager
任务管理器: TaskManager是主要干活的
1、Flink的工作进程。通常在Flink中会有多个TaskManager运行， 每一个TaskManager都包含了一定数量的插槽(slot).
   插槽的数量限制了TaskManager能够执行的任务数量。
2、启动之后，TaskManager会向资源管理器注册它的插槽，受到资源管理器的指令后，TaskManager就会将一个或者多个插槽提供给JobManager调用。
   JobManager就可以向插槽分配tasks来执行。
3、在执行的过程中， 一个TaskManager可以跟其他运行同一应用程序的TaskManager交换数据

o(*￣▽￣*)ブ ResourceManager
资源管理器:
1、主要负责管理任务管理器(TaskManager)的插槽(slot)，TaskManager插槽是flink中定义的处理资源单元。
2、Flink为不同的环境和资源管理工具提供了不同资源管理器，比如YARN、Mesos、K8s以及standalone部署/
3、当JobManager申请插槽资源是， ResourceManager会将有空闲插槽的TaskManager分配给JobManager。
   如果ResourceManager没有足够的插槽来满足JobManager的请求， 它还可以向资源提供平台发起会话， 以提供启动TaskManager进程的容器。

o(*￣▽￣*)ブ Dispatcher（分发器）
1、可以跨作业运行， 它为应用提交提供了REST接口
2、当一个应用被提交执行时，分发器就会启动并将应用移交给一个JobManager
3、Dispatcher也会启动一个web ui， 用来方便展示和监控作业执行的信息
4、Dispatcher在架构中可能并不是必需的，这取决于应用提交运行的方式

并行度(Parallelism):
一个特定算子的子任务(subtask)的个数被称之为其并行度(Parallelism)。
一般情况下，一个stream的并行度，可以认为就是其所有算子中最大的并行度。

TaskManager和Slots
Flink中每一个TaskManager都是一个JVM进程， 他可能会在独立的线程上执行一个或多个子任务。
为了控制一个TaskManager能够接收多少个task，TaskManager通过task slot来进行控制
（一个TaskManager至少有一个slot）
默认情况下，flink允许子任务共享slot，即使他们是不同的任务的子任务。这样的结果是，一个slot可以保存作业的整个管道。
Task Slot是静态的概念， 是指TaskManager具有的并发执行能力。

程序和数据流(DataFlow)
所有的Flink程序都是由三部分组成的， Source， Transformation 和Sink。
Source负责读取数据源， Transformation利用各种算子进行处理加工， Sink负责输出。
在运行时， Flink上运行的程序会被映射成逻辑数据流(dataflows), 它包含了这三部分。
每一个dataflow以一个或多个sources开始以一个或多个sinks结束。dataflow类似于任意的有向无环图（DAG）。
大部分情况下，程序中转换运算(transformations)跟dataflow中的算子（operator）是一一对应的关系。

执行图(ExecutionGraph)
Flink中的执行图可以分为四层：StreamGraph > JobGraph > ExecutionGraph > 物理执行图
StreamGraph: 是根据用户通过Stream API编写的代码生成的最初的图。用来表示程序的拓扑结构
JobGraph: 作业图，StreamGraph经过优化后生成了JobGraph，提交给JobManager的数据结构。主要的优化为，将多个符合条件的节点chain在一起作为一个节点。
ExecutionGraph: JobManager根据JobGraph生成ExecutionGraph。
    ExecutionGraph是JobGraph的并行化版本，是调度层最核心的数据结构。
物理执行图：JobManager根据ExecutionGraph对Job进行调度后，在各个TaskManager上部署Task后形成的“图”， 并不是一个具体的数据结构

数据传输形式
一个程序中，不同的算子可能具有不同的并行度
算子之间传输数据的形式可以是one-to-one(forwarding)的模式也可以是redistributing的模式， 具体是哪一种形式，取决于算子的种类。
one-to-one：stream维护者分区以及元素的顺序，（比如source和map之间）。
    这意味着map算子的子任务看到的元素个数以及顺序跟source算子的子任务生产的元素的个数，顺序相同。
    map、filter、flatMap等算子都是one-to-one的对应关系。
edistributing(重分区)：stream的分区会发生变化。每一个算子的子任务根据所选择的transformation发送数据到不同的目标任务。
    例如：KeyBy基于hashCode重分区，而broadcast和rebalance会随机重新分区，这些算子都会引起edistribute过程。
    而edistribute过程就类似于Spark中的shuffle过程

任务链（Operator Chain）
Flink采用了一种称为任务链的优化技术，可以在特定条件下减少本地通信的开销。为了满足任务连的要求，必须将两个或多个算子设为相同的并行度，
并通过本地转发local forward的方式进行连接。
相同并行度的one-to-one操作，Flink这样相连的算子连接在一起形成一个task，原来的算子成为里面的subtask.
并行度相同，并且是one-to-one操作，两个条件缺一不可。

```

## Flink 流处理API
```text
environment > source > transformation > sink
1、getExecutionEnvironment
    创建一个执行环境， 表示当前执行程序的上下文。如果程序是独立调用的，则此方法返回本地执行环境。
    如果从命令行客户端调用程序以提交到集群，则此方法返回此集群的执行环境，即：
    getExecutionEnvironment会根据查询运行的方式决定返回什么样的运行环境，是一中常用的创建执行环境的方式
    val env = StreamExecutionEnvironment.getExecutionEnvironment

Source

transformation

Flink支持的数据类型:
Java和Scala支持的所有基础数据类型
Java和Scala元组
Scala样例类
Java简单对象(POJOs)
以及Arrays,Lists,Maps,Enums

实现UDF函数 -- 更细粒度的控制流
函数类(function classes)
Flink曝露了所有udf函数的接口(实现方式为接口或者抽象类)
匿名函数
富函数，可以获取到运行时上下文，还有一些生命周期


Sink
Flink输出到外部存储系统：
Kafka
Cassandra
Kinesis Streams
ES
Hadoop FileSystem
RabbitMQ
NiFi
Streaming API
Bahir：为大数据工具提供连接支持



```

## Flink Window API
```text
窗口（Window）
一般真实的流都是无界的，怎么处理无界的数据?
1、可以把无限的数据流进行切分，得到无限的数据集进行处理、也就是得到无界流
2、窗口(Window)就是将无限流切割为有限流的一种方式，它会将数据分发到有限大小的桶(bucket)中进行分析
window类型
1、时间窗口(Time Window)
滚动时间窗口(Tumbling Windows):
    将数据依据固定的窗口长度对数据进行切分
    时间对齐、窗口长度(window size)固定、没有重叠
滑动时间窗口(Sliding Windows):
    滑动窗口是固定窗口的更广义的一种形式，滑动窗口由固定的窗口长度(window size)和滑动间隔(window slide)组成
    窗口长度固定，可以有重叠
会话窗口(session windows):
    由一系列事件组合一个指定时间长度的timeout间隙组成，也就是一段时间没有接收到新数据就会生成新的窗口
    特点：时间无对齐

窗口分配器--window()方法
注意window()方法必须在KeyBy之后才能用
Flink提供了更加简单的.timeWindow和.countWindow方法,用于定义时间窗口和计数窗口

2、计数窗口(Count Window)
滚动计数窗口
滑动计数窗口
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
