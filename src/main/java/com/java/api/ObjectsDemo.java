package com.java.api;

import com.java.api.pojo.Student;

import java.util.Objects;

/**
 * description:
 * author: ws
 * time: 2020/3/8 18:41
 */
public class ObjectsDemo {
    public static void main(String[] args) {
//        public static String toString(对象)   返回参数中对象的字符串表示形式
//        Student s = new Student("小罗同学", 50);
//        String result = Objects.toString(s);
//        System.out.println(result);
//        System.out.println(s);  //相当于直接打印对象的toString方法

//        public static String toString(对象,默认字符串)   返回参数中对象的字符串表示形式，如果对象为null，那么返回第二个参数,从而避免了出现空指针异常情况
//        Student  s = new Student("小花同学",23);
//        Student s = null;
//        String result = Objects.toString(s, "随便写一个");
//        System.out.println(result);

//        public static Boolean isNull(对象)    判断对象是否为空
//        Student s = null;
//        boolean result = Objects.isNull(s);
//        System.out.println(result); //true

//        public static Boolean nonNull(对象)   判断对象是否不为空
//        Student s = new Student();
//        boolean result = Objects.nonNull(s);
//        System.out.println(result); //true


        String[] strArray ={"11","22"};
        String haha = Objects.toString(strArray[3], "haha");
        System.out.println(haha);


    }


}
