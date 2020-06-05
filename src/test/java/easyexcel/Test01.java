package easyexcel;


import java.util.HashMap;
import java.util.Map;

/**
 * @description: 描述
 * @author: ws
 * @time: 2020/5/20 15:42
 */

public class Test01 {
    public static void main(String[] args) {
//       Stri ng str = "1,2,3,4,5";
//        String[] split = StringUtils.split(str, ",");
//        StringBuilder sb = new StringBuilder();
//        sb.append("?,").appendCodePoint(3);
//        System.out.println(sb.toString());

        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        System.out.println(map.get("1"));
        System.out.println("----------------------");
        map.put("1", "2");
        System.out.println(map.get("1"));

    }
}
