package com.java.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.fastjson.JSON;
import com.java.easyexcel.pojo.DemoHead;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * description: 练习数据写入到生成的excel
 * author: ws
 * time: 2020/3/22 11:51
 */
public class ExcelWriteTest {

    /*public static void main(String[] args) {
        DemoHead dh = new DemoHead();
        dh.setString("ws");
        dh.setDate(new Date());
        dh.setDoubleData(3.14);
        System.out.println(dh);
        System.out.println(JSON.toJSONString(dh));

    }*/

   /**
     * 最简单的将数据写入excel
     * 方式一：不创建对象的写
     */
    @Test
    public void simpleWrite1() {
        //写法一:doWrite()方法包含关闭流
        String fileName =  System.getProperty("user.dir") + File.separator + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        EasyExcel.write(fileName, DemoHead.class).sheet("sheet1").doWrite(data());
    }

    /**
     * 最简单的将数据写入excel方式
     * 方式二：创建对象的写
     */
    @Test
    public void simpleWrite2() {
        //写法二
//        String fileName =  ExcelWriteTest.class.getResource("/").getPath() + System.currentTimeMillis() + ".xlsx";
        String fileName =  System.getProperty("user.dir") + "/" + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        //这里需要指定写用哪个class去写
        ExcelWriter excelWriter = EasyExcel.write(fileName, DemoHead.class).build(); //生成空白excel文件，若无表头 去掉DemoHead.class对象即可
        WriteSheet writeSheet = EasyExcel.writerSheet("sheet1").build(); //生成第一个sheet页
        excelWriter.write(data(), writeSheet);

        //千万别忘记finish，会帮忙关闭流
        excelWriter.finish();
    }



    /**
     * 方法，作用:造10行数据
     * @return
     */
    private List<DemoHead> data() {
        List<DemoHead> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoHead headData = new DemoHead();
            headData.setString("字符串" + i);
            headData.setDate(new Date());
            headData.setDoubleData(3.14);
            list.add(headData);
        }
        return list;
    }

}
