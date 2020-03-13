package com.java.api;

import org.junit.Test;

/**
 * description: 冒泡排序
 * author: ws
 * time: 2020/3/12 20:25
 */
public class BubbleSortDemo {
    /**
     *  第一版冒泡排序实现
     */
    @Test
    public void test1() {
        int []  arr =  {3,5,2,1,4};
        //最终实现：1 2 3 4 5

        //第一轮
        //把最大值5找出，并把它放到数组的最右边
        //-1 是为了让索引不超出范围，数组越界
        for (int i = 0; i < arr.length -1; i++) {
            if(arr[i] > arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];// 把 i+1的值赋给i
                arr[i+1] = temp;
            }
        }

        printArr(arr);

        //第二轮
        for (int i = 0; i < arr.length -2; i++) {
            if(arr[i] > arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];// 把 i+1的值赋给i
                arr[i+1] = temp;
            }
        }

        printArr(arr);
        //第三轮
        for (int i = 0; i < arr.length -3; i++) {
            if(arr[i] > arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];// 把 i+1的值赋给i
                arr[i+1] = temp;
            }
        }

        printArr(arr);
        //第四轮
        for (int i = 0; i < arr.length -4; i++) {
            if(arr[i] > arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];// 把 i+1的值赋给i
                arr[i+1] = temp;
            }
        }

        printArr(arr);

    }


    /**
     *  冒泡排序简化版
     */
    @Test
    public void test2() {
        int []  arr =  {3,5,2,1,4};
        //最终实现：1 2 3 4 5
        bubbleSort(arr);


    }

    private void bubbleSort(int[] arr) {
        //外层循环控制的是次数，比数组的长度上一次
        for (int i = 0; i < arr.length-1; i++) {
            //内层循环就是实际循环比较的
            //-1是为了让数组不要越界
            //-i每一轮结束之后 ，我们就会少比一个数字
            for (int j = 0; j < arr.length -1 - i; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];// 把 i+1的值赋给i
                    arr[j+1] = temp;
                }
            }

            printArr(arr);

        }
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "");
        }
        System.out.println();
    }


}
