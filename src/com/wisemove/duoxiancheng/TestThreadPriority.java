package com.wisemove.duoxiancheng;

public class TestThreadPriority {

    public static void main(String[] args) {
        // 所有的线程初始情况下优先级都是5，主线程的优先级不能改，其他线程的优先级可以改动。

        Priority priority = new Priority();
        Thread t1 = new Thread(priority, "t1");
        Thread t2 = new Thread(priority, "t2");
        Thread t3 = new Thread(priority, "t3");
        Thread t4 = new Thread(priority, "t4");
        Thread t5 = new Thread(priority, "t5");
        Thread t6 = new Thread(priority, "t6");
        Thread t7 = new Thread(priority, "t7");
        Thread t8 = new Thread(priority, "t8");
        Thread t9 = new Thread(priority, "t9");
        Thread t10 = new Thread(priority, "t10");

        t1.setPriority(1);
        t2.setPriority(2);
        t3.setPriority(3);
        t4.setPriority(4);
        t5.setPriority(5);
        t6.setPriority(6);
        t7.setPriority(7);
        t8.setPriority(8);
        t9.setPriority(9);
        t10.setPriority(10);


        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();

        System.out.println("主线程的优先级为：" + Thread.currentThread().getPriority());
    }
}

class Priority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "的优先级为：" + Thread.currentThread().getPriority());
    }
}
