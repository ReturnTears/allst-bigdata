package com.allst.scala.collect;

import java.util.ArrayList;

/**
 * Java集合
 * @author YiYa
 * @since 2019-10-16 下午 10:02
 */
public class JavaCollect {
    public static void main(String[] args) {
        int[] nums = new int[3];
        nums[2] = 11;
        // nums[3] = 12;   //  数组下标越界

        // 可变集合
        ArrayList<String> arr = new ArrayList<>();
        arr.add("hello");
        arr.add("world");
        System.out.println(arr.hashCode());
    }
}
