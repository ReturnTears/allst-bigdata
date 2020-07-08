package com.allst.java.flink;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.source.RichParallelSourceFunction;

/**
 * 自定义实现一个支持多并行度的Source
 * RichParallelSourceFunction会额外提供open和close方法
 * 如果在source中需要获取其他链接资源，那么可以在open中打开资源，在close中关闭资源
 *
 * @author YiYa
 * @since 2020/7/8-16:24
 */
public class FlinkRichParallelSourceFunction extends RichParallelSourceFunction<Long> {
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

    /**
     * 这个方法会在最开始的时候被调用一次
     * @param parameters 参数
     * @throws Exception 异常
     */
    @Override
    public void open(Configuration parameters) throws Exception {
        System.out.println("open().......");
        super.open(parameters);
    }

    /**
     * 实现关闭连接
     * @throws Exception 异常
     */
    @Override
    public void close() throws Exception {
        super.close();
    }
}
