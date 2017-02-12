package com.hevin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>(4);    // 推荐默认指定大小
        a.add("1");
        a.add("2");
        a.add("1");

//        Iterator<String> it = a.iterator();
//        while (it.hasNext()) {
//            String temp = it.next();
//            if ("1".equals(temp)) {
//                it.remove();
//            }
//        }

//        使用 set 来去重
        Set<String> b = new HashSet<>(4);
        System.out.println(b.toString());

        AtomicInteger count = new AtomicInteger();
        count.addAndGet(1);
    }
}
