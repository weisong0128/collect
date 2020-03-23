package easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import easyexcel.pojo.DemoHead;
import org.junit.Test;

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

    /**
     * 无表头生成excel
     * @throws IOException
     */
    /*@Test
    public void writeWithoutHead()  {
        try {
            OutputStream out = new FileOutputStream("withoutHead.xlsx");
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, false);
            //第一个1代表sheet1，第二个0代表从第0行开始
            Sheet sheet1 = new Sheet(1, 0);
            sheet1.setSheetName("_sheet1");
            List<List<String>> data  = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                //每一行的数据
                List<String> item =  new ArrayList<>();
                item.add("item0" + i);
                item.add("item1" + i);
                item.add("item2" + i);
                data.add(item);
            }
            writer.write0(data, sheet1);
            writer.finish();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }*/

    /**
     * 含表头生成excel方式一
     */
    /*@Test
    public void writeWithHead1() {
        try {
            OutputStream out = new FileOutputStream("withHead1.xlsx");
            ExcelWriter writer = new ExcelWriter(out,  ExcelTypeEnum.XLSX);
            Sheet sheet = new Sheet(1, 0);
            sheet.setSheetName("withHead_sheet");

            //配置好表头信息
            List<List<String>> head = new ArrayList<>();
            List<String> headCoulumn1 = new ArrayList<String>();
            List<String> headCoulumn2 = new ArrayList<String>();
            List<String> headCoulumn3 = new ArrayList<String>();
            headCoulumn1.add("姓名");
            headCoulumn2.add("年龄");
            headCoulumn3.add("性别");
            head.add(headCoulumn1);
            head.add(headCoulumn2);
            head.add(headCoulumn3);
            Table table = new Table(1);
            table.setHead(head);

            //配置每列,每行数据信息
            List<List<String>> data = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                //每一行的数据
                List<String> fieldData = new ArrayList<>();
                fieldData.add("魏松" + i);
                fieldData.add("27" + i);
                fieldData.add("男" + i);
                data.add(fieldData);
            }

            writer.write0(data, sheet, table);
            writer.finish();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }*/


    /**
     * 含表头生成excel方式二：借助pojo实体类，推荐！
     * pojo形式 适合字段很多，大宽表形式
     */
    /*@Test
    public void writeWithHead2() {
        try {
            OutputStream out = new FileOutputStream("withHead2.xlsx");
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            Sheet sheet = new Sheet(1,0, DemoHead.class);
            sheet.setSheetName("withHead_sheet");
            List<List<String>> data =  new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                //每一行的数据
                List<String> fieldData = new ArrayList<>();
                fieldData.add("魏松" + i);
                fieldData.add("27" + i);
                fieldData.add("男" + i);
                data.add(fieldData);
            }
            writer.write0(data, sheet);
            writer.finish();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }*/


    @Test
    public void simpleWrite() {
        String fileName =  ExcelWriteTest.class.getResource("/").getPath() + System.currentTimeMillis() + ".xlsx";
//        String fileName =  System.currentTimeMillis() + ".xlsx";
        //这里需要指定写用哪个class去写
        ExcelWriter excelWriter = EasyExcel.write(fileName, DemoHead.class).build(); //生成空白excel文件
        WriteSheet writeSheet = EasyExcel.writerSheet("sheet1").build(); //生成第一个sheet页
        excelWriter.write(data(), writeSheet);
        //千万别忘记finish，会帮忙关闭流
        excelWriter.finish();

    }

    /**
     * 造10行数据
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
