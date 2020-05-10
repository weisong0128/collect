package com.java.throwable;

/**
 * @description: 栈溢出案例
 * @author: ws
 * @time: 2020/4/27 10:47
 */

public class StackOverFlowTest {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        while(true) {
            test1();
        }
    }
}
