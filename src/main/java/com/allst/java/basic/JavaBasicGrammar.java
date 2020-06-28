package com.allst.java.basic;

/**
 * Java基础语法
 * @author YiYa
 * @since 2020/6/24-16:00
 */
public class JavaBasicGrammar {
    public static void main(String[] args) {
        String name = "HelloJava";
        boolean nameHasUpperCase = false;
        for (int i = 0; i < name.length(); i++) {
            if (Character.isUpperCase(name.charAt(i))) {
                nameHasUpperCase = true;
                break;
            }
        }
        System.out.println(nameHasUpperCase ? "字符串中包含大写字母" : "字符串中没有包含大写字母");
    }
}