package com.wisemove.duoxiancheng;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 测试线程池
public class TestThreadPool {
    public static void main(String[] args) {
        // 1. 创建线程池, 参数为线程池大小
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // 2. 执行runnable的实现类
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());

        // 3. 关闭连接
        executorService.shutdownNow();
    }
}


class MyThread implements Runnable{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }
}
