package com.java.easyexcel;

import com.java.easyexcel.pojo.DemoHead;

import java.util.List;

/**
 * description: 假设这个是你的DAO存储。当然还要这个类让spring管理，当然你不用需要存储，也不需要这个类。
 * author: ws
 * time: 2020/3/22 20:41
 */
public class DemoDAO {
    public void save(List<DemoHead> list) {
        // 如果是mybatis,尽量别直接调用多次insert,自己写一个mapper里面新增一个方法batchInsert,所有数据一次性插入
    }
}
