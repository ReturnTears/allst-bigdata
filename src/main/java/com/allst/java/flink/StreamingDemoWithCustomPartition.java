package com.allst.java.flink;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple1;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * 使用自定义的FlinkCustomPartitioner分区
 *
 * @author YiYa
 * @since 2020/7/8-16:49
 */
public class StreamingDemoWithCustomPartition {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(2);
        DataStreamSource<Long> text = env.addSource(new FlinkNoParalleSource());
        // 对数据进行转换， 把Long类型转成Tuple1类型
        DataStream<Tuple1<Long>> tupleData = text.map(new MapFunction<Long, Tuple1<Long>>() {
            @Override
            public Tuple1<Long> map(Long aLong) throws Exception {
                return new Tuple1<>(aLong);
            }
        });
        // 分区之后的数据
        DataStream<Tuple1<Long>> partitionData = tupleData.partitionCustom(new FlinkCustomPartitioner(), 0);
        DataStream<Long> result = partitionData.map((MapFunction<Tuple1<Long>, Long>) value -> {
            System.out.println("当前线程id: " + Thread.currentThread().getId() + ", value : " + value);
            return value.getField(0);
        });

        result.print().setParallelism(1);
        env.execute("StreamingDemoWithCustomPartition");
    }
}
