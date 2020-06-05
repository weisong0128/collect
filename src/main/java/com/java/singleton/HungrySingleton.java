package com.java.singleton;

/**
 * @description: 饿汉式（线程安全，调用效率高，但是不能延迟加载，即出现内存浪费）
 * @author: ws
 * @time: 2020/6/3 15:32
 */

public class HungrySingleton {
    //构建单例对象
    private static final HungrySingleton instance = new HungrySingleton();
    //构造方法私有化
    private HungrySingleton(){

    };
    //提供一个全局的访问点
    public static HungrySingleton getInstance() {
        return instance;
    }




}
