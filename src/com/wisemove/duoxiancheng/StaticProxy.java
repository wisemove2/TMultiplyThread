package com.wisemove.duoxiancheng;

interface Marry{
    void marry();
}


public class StaticProxy {
    public static void main(String[] args) {
        WiseMove wisemove = new WiseMove();
        WeddingCompany weddingCompany = new WeddingCompany(wisemove);

        weddingCompany.marry();
    }
}


class WiseMove implements Marry{
    @Override
    public void marry() {
        System.out.println("结婚了，很开心~");
    }
}

class WeddingCompany implements Marry{

    private Marry user;

    public WeddingCompany(Marry user) {
        this.user = user;
    }

    @Override
    public void marry() {
        before();
        this.user.marry();
        after();
    }

    private void after() {
        System.out.println("结婚之后，收尾款！");
    }

    private void before() {
        System.out.println("结婚之前，布置现场");
    }
}