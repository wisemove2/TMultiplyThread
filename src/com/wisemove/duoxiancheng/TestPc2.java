package com.wisemove.duoxiancheng;

public class TestPc2 {
    public static void main(String[] args) {
        TV tv = new TV();
        Player player = new Player(tv);
        Watcher watcher = new Watcher(tv);

        player.start();
        watcher.start();
    }
}

class Player extends Thread{
    TV tv;
    public Player(TV tv){
        this.tv = tv;
    }

    @Override
    public void run(){
        for (int i = 0; i < 20; i++) {
            if(i % 2 == 0){
                this.tv.play("cctv");
            }else{
                this.tv.play("hbws");
            }
        }
    }
}

class Watcher extends Thread{
    TV tv;
    public Watcher(TV tv){
        this.tv = tv;
    }

    @Override
    public void run(){
        for (int i = 0; i < 20; i++) {
            this.tv.watch();
        }
    }
}

class TV{
    String content;
    boolean flag = true;

    public synchronized void play(String content){
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("表演了：" + content);

        this.notifyAll();
        this.flag = !this.flag;
        this.content = content;
    }

    public synchronized void watch(){
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("观看了：" + content);

        this.notifyAll();
        this.flag = !this.flag;
    }
}
