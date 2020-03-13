package com.java.api;

/**
 * description:二分查找法
 * author: ws
 * time: 2020/3/10 21:39
 */
public class BinarySearchDemo {
    public static void main(String[] args) {
        int [] arr =  {1,2,3,4,5,6,7,8,9,10};
        int number = 3; //[0,9] = 5 -->[0,3] = 2 -->[2,3] = 3   循环3次

        //1.我现在要干嘛？     --- 二分查找
        //2.我干这件事需要什么 ？ --数组 元素
        //3.我干完 了，要不要把结果返回给调用者  -- 把索引返回给调用者

        int index = binarySearchForIndex(arr,number);
        System.out.println("index=" + index);
    }

    private static int binarySearchForIndex(int[] arr, int number) {
        //1.定义查找的范围
        int min = 0;
        int max = arr.length - 1;

        //2. 循环查找 min < max
        int frequency = 0; //记录循环次数 二分法时间复杂度:O(logN)
        while (min <  max){
            //3.计算出中间位置 mid
            int mid = (min + max)  >> 1; // 就是两和 除以2的高级写法
            //mid指向的元素 > number
            if(arr[mid] >  number){
                //表示要查找的元素在左边
                max = mid -1;
                frequency += 1;
            }else if (arr[mid] <  number){
                //mid指向的元素 < number
                min = mid + 1;
                frequency += 1;
            }else{
                frequency += 1;
                System.out.println("frequency=" + frequency);
                //mid指向的元素 == number
                return mid;
            }
        }
        //如果min大于了max就表示元素不存在，返回-1
        return -1;
    }
}
