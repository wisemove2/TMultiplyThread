package com.wisemove.duoxiancheng;

// 1. 继承Runnable接口
public class TestRunnable01 implements Runnable{
    // 2. 重写run方法
    @Override
    public void run(){
        for(int i = 0; i < 2000; i++){
            System.out.println("子线程在执行：" + i);
        }
    }

    public static void main(String[] args) {
        TestRunnable01 tr1 = new TestRunnable01();

        // 3. 将runnable接口的实现类传入thread中，并且调用start实现多线程调用
        new Thread(tr1).start();

        for(int i = 0; i < 2000; i++){
            System.out.println("主线程在执行：" + i);
        }
    }
}
