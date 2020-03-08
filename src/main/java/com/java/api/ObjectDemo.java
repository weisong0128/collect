package com.java.api;

import com.java.api.pojo.Student;

/**
 * description: 描述
 * author: ws
 * time: 2020/3/7 11:25
 */

public class ObjectDemo {
    public static void main(String[] args) {
        //1.学习toString方法
//        Student s =  new Student("张三",23);
//        System.out.println(s);//com.java.api.pojo.Student@2503dbd3
//        System.out.println(s.toString());


        //2.学习equals方法
//        Student s1 =  new Student("张三",23);
//        Student s2 =  new Student("张三",23);
//        System.out.println(s1==s2);//false，因为==是比较引用数据类型，是比较地址值
//        //Object类中的equals方法，底层也是用==号比较地址值
//        System.out.println(s1.equals(s2));//false，因为Student类中没有重写equals方法，所以调用的是Object中的equals方法


        //面试题
        String str = "123";
        StringBuilder sb = new StringBuilder("123");
        System.out.println(str.equals(sb));//false 因为equals方法里的参数不是String类型，直接返回false
        System.out.println(sb.equals(str));//false，sb没有重写equals方法,调用的Object类的equals方法，比较的是地址值

    }
}
