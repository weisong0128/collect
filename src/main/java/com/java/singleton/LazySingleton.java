package com.java.singleton;

/**
 * @description: 懒汉式，可以延迟加载，即解决了饿汉式单例可能带来的内存浪费问题
 * 注意：
 * @author: ws
 * @time: 2020/6/3 15:36
 */

public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {};

    //线程不安全，能防止内存浪费
    public static LazySingleton getInstance() {
        if (null == instance) {
            instance = new LazySingleton();
        }
        return instance;
    }

    //线程安全，但效率低，但是能防止内存浪费，不如静态内部类实现方式
    /*public static synchronized LazySingleton getInstance1() {
        if (null == instance) {
            instance = new LazySingleton();
        }
        return instance;
    }*/

}
