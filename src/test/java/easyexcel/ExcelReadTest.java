package easyexcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * description: 练习从excel中读取数据
 * author: ws
 * time: 2020/3/22 16:07
 */
public class ExcelReadTest {


    public void readTest1() {
        String filePath = System.getProperty("user.dir") + "/" +  "withHead1.xlsx";

        try {
            InputStream input = new FileInputStream("withHead1.xlsx");
//            ExcelReader reader = new ExcelReader(input, ExcelTypeEnum.XLSX);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

}
