package com.allst.java.flink;

import org.apache.flink.streaming.api.functions.source.SourceFunction;

/**
 * 自定义实现并行度为1的Source
 *
 * @author YiYa
 * @since 2020/7/8-16:04
 */
public class FlinkNoParalleSource implements SourceFunction<Long> {

    private long count = 1L;

    private boolean isRunning = true;

    /**
     * 主要方法：启动一个Source，大部分情况下，都需要在这个run方法中实现一个循环，这样就可以产生循环了
     *
     * @param sourceContext 上下文
     * @throws Exception 异常
     */
    @Override
    public void run(SourceContext<Long> sourceContext) throws Exception {
        while (isRunning) {
            sourceContext.collect(count);
            count++;
            Thread.sleep(1000); // 每秒产生一条数据
        }
    }

    /**
     * 执行cancel操作时会调用此方法
     */
    @Override
    public void cancel() {
        isRunning = false;
    }
}
