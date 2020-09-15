package com.allst.scala.comm_use;

/**
 * java在序列中查找最大或最小值
 * @author JUNN
 * @since 2019-07-13 下午 12:25
 */
public class MaxValue_Java {
    public static void main(String[] args) {
        evalMaxVal();
    }

    /**
     * 计算最大值
     */
    private static void evalMaxVal() {
        int[] arr = {11, 2, 5, 1, 6, 3, 9, 17, 22};
        int to = arr.length - 1;
        int max = arr[0];
        for (int i = 0; i < to; i++) {
            if (max < arr[i + 1]) {
                max = arr[i + 1];
            }
        }
        System.out.println("Max Value : " + max);
    }
}
