package com.allst.scala.collect;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YiYa
 * @since 2019-11-03 上午 09:15
 */
public class TotalNums {
    public static void main(String[] args) {
        String sentence = "AAAAABBBBBCCCCCDDDDD";
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        char[] cs = sentence.toCharArray();
        for (char c : cs) {
            if (characterIntegerMap.containsKey(c)) {
                Integer count = characterIntegerMap.get(c);
                characterIntegerMap.put(c, count+1);
            } else {
                characterIntegerMap.put(c, 1);
            }
        }

        System.out.println(characterIntegerMap);
    }
}
