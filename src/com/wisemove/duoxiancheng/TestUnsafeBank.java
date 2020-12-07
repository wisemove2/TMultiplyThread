package com.wisemove.duoxiancheng;

public class TestUnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(100, "结婚基金");

        Drawing wo = new Drawing(account, 50, "我");
        Drawing ni = new Drawing(account, 100, "你");

        wo.start();
        ni.start();
    }
}

class Drawing extends Thread{
    private Account account;
    private int money;
    private String name;
    private int now_money;

    public Drawing(Account account, int money, String name){
        this.account = account;
        this.money = money;
        this.name = name;
        this.now_money = 0;
    }

    @Override
    public void run(){
        synchronized (account){
            if(account.getMoney() - money < 0){
                System.out.println(Thread.currentThread().getName() + "钱不够了");
                return;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            account.setMoney(account.getMoney() - money);
            now_money = now_money + money;
            System.out.println("余额为:" + account.getMoney());
            System.out.println(this.name + "手里的钱有" + now_money);
        }
    }
}

class Account{
    private int money;
    private String name;

    public Account(int money, String name){
        this.money = money;
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
