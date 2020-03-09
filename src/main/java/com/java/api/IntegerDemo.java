package com.java.api;

/**
 * description:
 * author: ws
 * time: 2020/3/9 20:11
 */
public class IntegerDemo {
    public static void main(String[] args) {
        //需求：我要判断一个整数是否在int范围内？
        //Integer
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);

        //下面两种已过时
//        Integer i1 = new Integer(100);
//        Integer i2 = new Integer("100");
//        System.out.println(i1);
//        System.out.println(i2);


//        public static Integer valueof(int i)    返回表示指定的int值的Integer实例
//        public static Integer valueof(String s) 返回一个保存指定值的Integer对象String
//        Integer i3 = Integer.valueOf(200);
//        Integer i4 = Integer.valueOf("200");
//        System.out.println(i3);
//        System.out.println(i4);

        //自动装箱/自动拆箱
        Integer i5 = 100;
        //   对象   = 默认是一个基本数据类型
        //jdk1.5的特性 ---  自动装箱
        //装箱：把一个基本数据类型变成 对应的包装类
        //自动：Java底层会帮我们自动的调用valueof方法

        //jdk1.5的特性 ---  自动拆箱
        //拆箱：把一个包装类型 变成对应的基本数据 类型
//        int i6 = i5;
//        Integer  i7 = 100;  //自动装箱机制
//        i7 +=  200; //i7 = i7 + 200;
//                    //会把 i7这个对象变成基本数据类型100;
//                    // 100 + 200 = 300
//                    //把基本数据类型300再次自动装箱变成Integer对象赋给i7

        //细节：
//        Integer  i8 = null;
//        i8 += 200;
//        System.out.println(i8); //报错 空指针
        //因为null可以赋给引用数据类型（对象），但是null无法转成基本数据类型

        String s1 = "100";
        //String -->  int
        int i2 = Integer.parseInt(s1);//可以将字符串类型的整数变成int类型的整数
        // int --> String
        //方式一： +""
        int i3  = 100;
        String s2 = i3 + "";
        // 方式二：可以调用String类中valueof方法
        String.valueOf(i3);

        //案例
        String  s = "91 27 46 38 50";
        String[] strArr = s.split(" ");
        //创建一个int类型的数组
        int [] numberArr = new int[strArr.length];
        //把str中的数据进行类型转换并存到int数组中
        for (int i = 0; i < strArr.length; i++) {
            int number = Integer.parseInt(strArr[i]);
            numberArr[i] = number;
        }
        //遍历int类型的数组
        for (int i = 0; i < numberArr.length; i++) {
            System.out.println(numberArr[i]);
        }


    }
}
