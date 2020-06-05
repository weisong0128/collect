package com.java.singleton;

/**
 * @description: 静态内部类实现方式，线程安全，调用效率高，可以延迟加载（防止内存浪费）
 * @author: ws
 * @time: 2020/6/3 15:41
 */

public class StaticSingleton {
    private static class SingletonClassInstance {
        private static final StaticSingleton instance = new StaticSingleton();
    }

    private StaticSingleton() {};

    public static StaticSingleton getInstance() {
        return SingletonClassInstance.instance;
    }

}
