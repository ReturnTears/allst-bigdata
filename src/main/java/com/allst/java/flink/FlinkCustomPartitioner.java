package com.allst.java.flink;

import org.apache.flink.api.common.functions.Partitioner;

/**
 * 创建自定义的分区规则，根据数字的奇偶性来分区
 * @author YiYa
 * @since 2020/7/8-16:47
 */
public class FlinkCustomPartitioner implements Partitioner<Long> {
    @Override
    public int partition(Long aLong, int i) {
        System.out.println("分区总数： " + i);
        if (aLong % 2 == 0) {
            return 0;
        }
        return 1;
    }
}
