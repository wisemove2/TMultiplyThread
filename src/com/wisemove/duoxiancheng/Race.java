package com.wisemove.duoxiancheng;


// 模拟龟兔赛跑
public class Race implements Runnable{

    private static String winner;

    @Override
    public void run() {
        for(int i = 0; i <= 100; i++){

            if(Thread.currentThread().getName().equals("兔子") && i % 40 == 0){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            // 判断比赛是否结束
            boolean flag = isGameOver(i);
            if(flag){
                break;
            }

            System.out.println(Thread.currentThread().getName() + " 跑了" + i + "米！");
        }
    }

    private boolean isGameOver(int steps){
        if(winner != null){
            return true;
        }else{
            if(steps == 100){
                winner = Thread.currentThread().getName();
                System.out.println("winner is " + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race, "兔子").start();
        new Thread(race, "乌龟").start();
    }
}
