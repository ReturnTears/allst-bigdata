package com.allst.java.flink;

import org.apache.flink.streaming.api.functions.source.ParallelSourceFunction;

/**
 * 自定义实现一个支持多并行度的Source
 *
 * @author YiYa
 * @since 2020/7/8-16:17
 */
public class FlinkParalleSource implements ParallelSourceFunction<Long> {

    private long count = 1L;
    private boolean isRunning = true;

    @Override
    public void run(SourceContext<Long> sourceContext) throws Exception {
        while (isRunning) {
            sourceContext.collect(count);
            count++;
            Thread.sleep(1000); // 每秒产生一条数据
        }
    }

    @Override
    public void cancel() {
        isRunning = false;
    }
}
