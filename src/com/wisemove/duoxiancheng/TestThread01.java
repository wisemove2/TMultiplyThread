package com.wisemove.duoxiancheng;

// 1. 继承Thread类
public class TestThread01 extends Thread{
    public static void main(String[] args) {

        TestThread01 thread01 = new TestThread01();

        // 3. 执行start方法
        thread01.start();
        // thread01.run();

        for(int i = 0; i < 2000; i++){
            System.out.println("主线程在执行：" + i);
        }
    }

    // 2. 重写run方法
    @Override
    public void run(){
        for(int i = 0; i < 2000; i++){
            System.out.println("子线程在执行：" + i);
        }
    }
}
