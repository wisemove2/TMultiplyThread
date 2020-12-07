package com.wisemove.duoxiancheng;

import java.util.ArrayList;
import java.util.List;

public class TestUnsafeCollection{
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        for (int i = 0; i < 100000; i++) {
            new Thread(() -> {
                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }

        try {
            Thread.sleep(200000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
