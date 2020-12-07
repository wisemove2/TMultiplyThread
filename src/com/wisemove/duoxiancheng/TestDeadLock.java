package com.wisemove.duoxiancheng;

public class TestDeadLock{
    public static void main(String[] args) {
        MakeUp g1 = new MakeUp(0, "灰姑凉");
        MakeUp g2 = new MakeUp(1, "白雪公主");

        g1.start();
        g2.start();
    }
}

class Mirror{

}

class LipStick{

}

class MakeUp extends Thread{
    static Mirror mirror = new Mirror();
    static LipStick lipStick = new LipStick();

    int choice;
    String name;

    public MakeUp(int choice, String name){
        this.choice = choice;
        this.name = name;
    }

    @Override
    public void run(){
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 形成死锁解决方式，分别去获取这两把锁。
    public void makeup() throws InterruptedException {
        if(choice == 0){
            synchronized (lipStick){
                System.out.println(name + "获得了口红！");
                Thread.sleep(1000);

                synchronized (mirror){
                    System.out.println(name + "获得了镜子！");
                }
            }
        }else{
            synchronized (mirror){
                System.out.println(name + "获得了镜子！");
                Thread.sleep(1000);

                synchronized (lipStick){
                    System.out.println(name + "获得了口红！");
                }
            }
        }
        // 下面这种方式就可以没有死锁，分别去获取这两把锁即可。
//        if(choice == 0){
//            synchronized (lipStick){
//                System.out.println(name + "获得了口红！");
//                Thread.sleep(1000);
//            }
//            synchronized (mirror){
//                System.out.println(name + "获得了镜子！");
//            }
//        }else{
//            synchronized (mirror){
//                System.out.println(name + "获得了镜子！");
//                Thread.sleep(1000);
//            }
//            synchronized (lipStick){
//                System.out.println(name + "获得了口红！");
//            }
//        }

    }
}
