package com.java.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @description: 针对insight项目中涉及的fastjson相关语法学习
 * @author: ws
 * @date: 2022-04-01 15:19
 **/
public class Test01 {

    public static void main(String[] args) {
        Test01 d = new Test01();
//        d.demoOne();
//        d.demoTwo();
//        d.demoThree();
        d.demoFour();
//        d.demoFive();

    }

    //1.通过原生生成json数据格式
    public void demoOne(){
        JSONObject zhangsan = new JSONObject();

        zhangsan.put("name", "张三");
        zhangsan.put("age", 18.4);
        zhangsan.put("birthday","1993-01-28");
        zhangsan.put("majar", new String[]{"哈哈","嘿嘿"});
        zhangsan.put("null", null);
        zhangsan.put("house", false);
        System.out.println(zhangsan.toString());
    }

    //2.通过hashMap数据结构生成
    public void demoTwo(){
        HashMap<String, Object> zhangsan = new HashMap<>();
        zhangsan.put("name", "张三");
        zhangsan.put("age", 18.4);
        zhangsan.put("birthday","1993-01-28");
        zhangsan.put("majar", new String[]{"哈哈","嘿嘿"});
        zhangsan.put("null", null);
        zhangsan.put("house", false);

        JSONObject jsonObject = new JSONObject(zhangsan);   //构造方法中可以传map对象
        System.out.println(jsonObject.toString());
    }

    //3.通过实体生成
    public void demoThree(){
        Student student = new Student();
        student.setId(1);
        student.setAge(20);
        student.setName("张三");
        JSONObject json = (JSONObject) JSON.toJSON(student); //生成json格式
        System.out.println(json);
        //或者
        System.out.println(JSONObject.toJSONString(student));//对象转成string
    }

    //4.JSON字符串转换成JSON对象
    public void demoFour(){
        String studentString = "{\"id\":1,\"age\":2,\"name\":\"zhang\"}";
        //JSON字符串转换成JSON对象
        JSONObject jsonObject = JSONObject.parseObject(studentString);
        System.out.println(jsonObject);
    }


    //5.list对象转listJSON，注意 这里转成的是list集合
    public void demoFive(){
        ArrayList<Object> studentList = new ArrayList<>();
        Student stu1 = new Student();
        stu1.setId(1);
        stu1.setAge(20);
        stu1.setName("张三");
        studentList.add(stu1);

        Student stu2 = new Student();
        stu2.setId(2);
        stu2.setAge(30);
        stu2.setName("李四");
        studentList.add(stu2);

        //list转json对象
        Object jsonObject =  JSON.toJSON(studentList);
        String str = jsonObject.toString();
        System.out.println(jsonObject);
        System.out.println("==============");
        System.out.println(str);

        //json字符串转listjson格式
        JSONArray jsonArray = JSONObject.parseArray(str);
        System.out.println("----------------");
        System.out.println(jsonArray);
    }

}
