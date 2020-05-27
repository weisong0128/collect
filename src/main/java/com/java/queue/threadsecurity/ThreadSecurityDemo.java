package com.java.queue.threadsecurity;

/**
 * @description:
 * @author: ws
 * @time: 2020/5/27 20:06
 */
public class ThreadSecurityDemo {
    private static User user = new User("jack", "123456");

    public static void main(String[] args) {
//        user.change("james", "66666666");
//        user.change("Mic", "88888888");
        new Thread(() -> {
            user.change("james", "66666666");
        }, "T1").start();

        new Thread(() -> {
            user.change("Mic", "88888888");
        }, "T2").start();
    }
}
