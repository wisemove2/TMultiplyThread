package com.wisemove.duoxiancheng;

public class TestThreadDaemon {

    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread godThread = new Thread(god);
        godThread.setDaemon(true);

        godThread.start();
        new Thread(you).start();
    }

}

class You implements Runnable{

    @Override
    public void run() {
        System.out.println("hello world!");
        for (int i = 0; i < 36500; i++) {
            System.out.println("开心的活了" + i + "天！");
        }
        System.out.println("goodbye world!");
    }
}


class God implements Runnable{

    @Override
    public void run() {
        while(true) {
            System.out.println("god bless you!");
        }
    }
}
