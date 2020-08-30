# Flink

## Flink 简介
```text
\color{red}Flink是什么?
Apache Flink是一个框架和分布式处理引擎, 用于对无界和有界数据流进行状态计算。

Flink应用场景很广泛

\color{red}为什么选择Flink?

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