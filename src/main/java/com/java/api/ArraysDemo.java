package com.java.api;

import java.util.Arrays;

/**
 * description:Arrays类：包含用于操作数组的各种方法
 * author: ws
 * time: 2020/3/13 21:00
 */
public class ArraysDemo {
    public static void main(String[] args) {
        //public static String  toString(int[] a)   返回指定数组的内容的字符串表示形式
//        int[] arr ={3,2,4,6,7};
//        System.out.println(Arrays.toString(arr));

        //public static void sort(int[] a)  按照数字顺序排列指定的数组
//        int[] arr ={3,2,4,6,7};
//        Arrays.sort(arr);   //这一步不能省略，必须先排序，此时arr顺序已经被改变!
//        System.out.println(Arrays.toString(arr));

        //public static int binarySearch(int[] a,int key)   利用二分查找返回指定元素的索引
        int[] arr ={3,2,4,6,7};
        Arrays.sort(arr);   //二分查找要先排序才行
        int index = Arrays.binarySearch(arr, 6);
        System.out.println("值为6的索引编号为:"+index);
    }
}
