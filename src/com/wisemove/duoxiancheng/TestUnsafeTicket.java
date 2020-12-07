package com.wisemove.duoxiancheng;

public class TestUnsafeTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket, "我").start();
        new Thread(buyTicket, "你").start();
        new Thread(buyTicket, "黄牛党").start();
    }
}

class BuyTicket implements Runnable{
    private int ticket = 1000;
    boolean flag = true;

    @Override
    public void run() {
        while(flag){
            buy();
        }
    }

    private synchronized void buy(){
        if(ticket <= 0){
            flag = false;
            return;
        }
        System.out.println(Thread.currentThread().getName() + "拿到" + ticket--);
    }

}
