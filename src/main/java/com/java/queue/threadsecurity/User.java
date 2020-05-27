package com.java.queue.threadsecurity;

/**
 * @description: 线程不安全示例
 * @author: ws
 * @time: 2020/5/27 20:02
 */
public class User {
    private String userName;
    private String passWord;

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
        System.out.println(Thread.currentThread().getName() + "--->userName=" + this.userName + ",passWord=" + this.passWord);
    }


    public synchronized void change(String userName, String passWord) {
        this.userName = userName;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.passWord = passWord;
        System.out.println(Thread.currentThread().getName() + "--->userName=" + this.userName + ",passWord=" + this.passWord);
    }

}
