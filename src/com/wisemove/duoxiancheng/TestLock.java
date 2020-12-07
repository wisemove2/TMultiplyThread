package com.wisemove.duoxiancheng;

import java.util.concurrent.locks.ReentrantLock;

// 测试lock
public class TestLock {
    public static void main(String[] args) {
        TLock tLock = new TLock();

        new Thread(tLock).start();
        new Thread(tLock).start();
        new Thread(tLock).start();
    }
}

class TLock implements Runnable{

    int ticknumber = 100;

    // 加锁
    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            lock.lock();
            while (true) {
                if (ticknumber > 0) {
                    System.out.println(ticknumber--);
                } else {
                    break;
                }
            }
        }finally {
            lock.unlock();
        }
    }
}
