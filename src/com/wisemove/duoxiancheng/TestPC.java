package com.wisemove.duoxiancheng;


import javax.swing.text.AsyncBoxView;

public class TestPC {

    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();

        new Productor(synContainer).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Consumer(synContainer).start();
    }
}

class Productor extends Thread{
    SynContainer container;

    public Productor(SynContainer synContainer){
        this.container = synContainer;
    }

    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            container.push(new Chicken(i));
            System.out.println("生产了 " + i + "只鸡！");
        }
    }
}

class Consumer extends Thread{
    SynContainer container;
    public Consumer(SynContainer synContainer){
        this.container = synContainer;
    }

    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了 " + container.pop().id + "只鸡！");
        }
    }
}


class Chicken{
    int id;

    public Chicken(int id){
        this.id = id;
    }
}

class SynContainer{
    // 产品
    Chicken[] chickens = new Chicken[10];
    // 计数器
    int count = 0;

    public synchronized void push(Chicken chicken){
        if(count == chickens.length){
            // 通知消费者消费，生产等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 如果没有满，丢入产品进去
        chickens[count] = chicken;
        count += 1;

        // 有产品了，通知消费者消费
        this.notifyAll();
    }

    public synchronized Chicken pop(){
        if(count == 0){
            // 消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 如果有产品了，开始准备消费了
        count -= 1;
        Chicken chicken = chickens[count];

        this.notifyAll();
        return chicken;
    }
}