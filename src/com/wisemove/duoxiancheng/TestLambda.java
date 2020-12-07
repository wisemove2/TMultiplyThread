package com.wisemove.duoxiancheng;

/*
* 推导lambda表达式
* */

public class TestLambda {
    // 3. 静态内部类
    static class ILike2 implements Like{
        @Override
        public void lambda() {
            System.out.println("I like lambda2!!");
        }
    }


    public static void main(String[] args) {
        Like iLike = new ILike();
        iLike.lambda();

        iLike = new ILike2();
        iLike.lambda();


        // 4. 局部内部类
        class ILike3 implements Like{
            @Override
            public void lambda() {
                System.out.println("I like lambda3!!");
            }
        }

        iLike = new ILike3();
        iLike.lambda();


        // 5. 匿名内部类
        iLike = new Like() {
            @Override
            public void lambda() {
                System.out.println("I like lambda4!!");
            }
        };
        iLike.lambda();

        // 6. JDK1.8简化，Lambda简化
        iLike = () -> {
            System.out.println("I like lambda5!!");
        };
        iLike.lambda();
    }
}


// 1. 定义一个接口
interface Like{
    void lambda();
}


// 2. 外部类
class ILike implements Like{
    @Override
    public void lambda() {
        System.out.println("I like lambda!!");
    }
}
