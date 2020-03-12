package com.java.api;

/**
 * description: 递归
 * author: ws
 * time: 2020/3/12 21:06
 */
public class FactorialDemo {
    public static void main(String[] args) {
        //求1-100之间的和
//        int sum = getSum(100);
//        System.out.println(sum);


        //递归求阶乘  5!=5*4*3*2*1   思考：可以是 5* (4的阶乘) ， 5*4* (3的阶乘)
        int factorial = getFactorial(5);
        System.out.println(factorial);
    }

    private static int getFactorial(int i) {
        if(i == 1){
            return 1;
        }else {
            return i * getFactorial(i-1);
        }
    }

    private static int getSum(int i) {
        //方法的作用： 求 1-i之间和
        // 100 +  (1-99之间的和)
                // 99 + (1-98之间的和)
                        //....
                            //1
        if(i == 1) {
            return 1;
        }else {
            return i + getSum(i-1);
        }


    }

}
