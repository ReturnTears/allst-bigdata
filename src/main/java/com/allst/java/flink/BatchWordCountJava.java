package com.allst.java.flink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

/**
 * 单词计数之离线计算
 * windows10本地可执行
 * @author YiYa
 * @since 2020/7/8-11:13
 */
public class BatchWordCountJava {
    public static void main(String[] args) throws Exception {
        String input = "E:\\TestData\\file\\input";
        String output = "E:\\TestData\\file\\javaOut";
        // 获取运行环境
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        // 获取文件中内容
        DataSource<String> text = env.readTextFile(input);
        DataSet<Tuple2<String, Integer>> counts = text.flatMap(new Tokenizer()).groupBy(0).sum(1);
        counts.writeAsCsv(output, "\n", " ").setParallelism(1);
        env.execute("batch word count.");
    }

    private static class Tokenizer implements FlatMapFunction<String, Tuple2<String, Integer>> {

        @Override
        public void flatMap(String value, Collector<Tuple2<String, Integer>> collector) throws Exception {
            String[] tokens = value.toLowerCase().split("\\W+ ");
            for (String token : tokens) {
                if (token.length() > 0)
                    collector.collect(new Tuple2<>(token, 1));
            }
        }
    }
}
