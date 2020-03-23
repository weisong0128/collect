package com.java.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.java.easyexcel.pojo.DemoHead;
import org.junit.Test;

import java.io.File;

/**
 * description: 练习从excel中读取数据
 * author: ws
 * time: 2020/3/22 16:07
 */
public class ExcelReadTest {

    /**
     * 最简单的将excel中数据读出
     * 写法一:doRead()方法包含关闭流，不创建对象的读
     */
    @Test
    public void simpleRead1() {
//        String fileName ="simpleWrite1584882547651.xlsx";
        String fileName =  System.getProperty("user.dir") + File.separator + "simpleWrite1584926113416.xlsx";
        EasyExcel.read(fileName, DemoHead.class, new DemoHeadListener()).sheet(0).doRead();
    }

    /**
     * 最简单的将excel中数据读出
     * 写法二：创建对象的读
     */
    @Test
    public void simpleRead2() {
        String fileName =  System.getProperty("user.dir") + File.separator + "simpleWrite1584882547651.xlsx";
        ExcelReader excelReader = EasyExcel.read(fileName, DemoHead.class, new DemoHeadListener()).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        excelReader.finish();
    }

}
