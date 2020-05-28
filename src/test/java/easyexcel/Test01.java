package easyexcel;

import org.apache.commons.lang3.StringUtils;

/**
 * @description: 描述
 * @author: ws
 * @time: 2020/5/20 15:42
 */

public class Test01 {
    public static void main(String[] args) {
        String str = "1,2,3,4,5";
        String[] split = StringUtils.split(str, ",");
        StringBuilder sb = new StringBuilder();
        sb.append("?,").appendCodePoint(3);
        System.out.println(sb.toString());
    }
}
