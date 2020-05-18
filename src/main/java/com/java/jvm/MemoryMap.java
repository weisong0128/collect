package com.java.jvm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @description: 描述
 * @author: ws
 * @time: 2020/5/15 14:10
 */

public class MemoryMap {
    static long bytes = 0;

    public static void main(String[] args) throws IOException { // Line 1
        Set<String> opt = new HashSet<String>();
        opt.addAll(Arrays.asList(args));
        List<String> list= new ArrayList< String>();
        if (opt.contains("alloc")) {
            for (int i = 0; i < 100; i++) {
                String s = foo(1024 * 1024, i); //100Mb
                bytes += s.getBytes().length;
                list.add(s);
            }
        }
        System.out.println("Bytes=" + bytes + ", press Enter to exit...");

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        if(opt.contains("gc")){
            System.gc();
        }
        String a = br.readLine();
        System.out.println(a);
        System.out.println(list.size());
    }

    private static String foo(long count, int k) { // Line 6
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < count; i++) {
            sb.append(i % 10);
        }
        sb.append(k);
        return sb.toString();
    }
}
