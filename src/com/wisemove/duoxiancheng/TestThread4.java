package com.wisemove.duoxiancheng;

// 多个线程同时操作同一个对象，线程不安全，数据紊乱。
public class TestThread4 implements Runnable{

    private int ticketNums = 10;

    @Override
    public void run() {
        do {
            System.out.println(Thread.currentThread().getName() + "拿到了第" + ticketNums + "张票！");
            ticketNums -= 1;
        } while (ticketNums > 0);
    }

    public static void main(String[] args) {
        TestThread4 tt4 = new TestThread4();

        new Thread(tt4, "小明").start();
        new Thread(tt4, "老师").start();
        new Thread(tt4, "黄牛党").start();
    }
}
