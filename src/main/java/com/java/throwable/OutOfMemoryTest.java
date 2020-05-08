package com.java.throwable;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 内存溢出案例
 * @author: ws
 * @time: 2020/4/27 10:50
 */

public class OutOfMemoryTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        while(true) {
            int[] temp = new int[1000000]; //new了一个对象temp
            list.add(temp);
        }
    }
}
