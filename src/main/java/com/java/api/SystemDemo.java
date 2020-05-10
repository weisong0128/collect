package com.java.api;

import java.net.URL;

/**
 * description: 获取当前时间：System.currentTimeMillis()，获取当前项目绝对路径：System.getProperty("user.dir")
 * author: ws
 * time: 2020/3/8 14:26
 */
public class SystemDemo {
    public static void main(String[] args) {
//        public static void exit(int static) 终止当前运行的java虚拟机，非零表示异常终止
//        System.out.println(111);
//        while (true){}
//        System.exit(0); //当代码执行到这个方法的时候，就表示虚拟机已经停止了
//        System.out.println(2222);

//        public static long currentTimeMillis()  返回当前时间（以毫秒为单位）
//        long start = System.currentTimeMillis();    //获取当前时间
//        //System.out.println(start);
//        for (int i = 0; i < 10000; i++) {
//            System.out.println(i);
//        }
//        long end = System.currentTimeMillis();  //获取当前时间
//        System.out.println(end-start);  //151 --得到的就是这个for循环运行的时间

//        arraycopy(数据源数组，起始索引，目的地数组，起始索引，拷贝个数)   数组coy
        int [] arr1 = {1,2,3,4,5};
        int [] arr2 = new int[10];
        //需求：我要把 arr1中的数据拷贝到arr2中
        System.arraycopy(arr1,0,arr2,0,arr1.length);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]);
        }
        System.out.println();
        //我要把arr1最后两个元素，拷贝到arr2的最后两个索引上
        System.arraycopy(arr1,3,arr2,8,2);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]);
        }
        System.out.println("=======");
        //获取当前工程路径
        System.out.println(System.getProperty("user.dir")); //结果：G:\git\ws\collect

        URL resource = SystemDemo.class.getResource("/");//结果：file:/G:/git/ws/collect/target/classes/
        System.out.println(resource);
    }
}
