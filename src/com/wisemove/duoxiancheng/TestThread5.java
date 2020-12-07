package com.wisemove.duoxiancheng;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class TestThread5 implements Callable<Boolean> {

    private final String url;
    private final String path;

    public TestThread5(String url, String path) {
        this.url = url;
        this.path = path;
    }




    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestThread5 t1 = new TestThread5("https://career.huawei.com/reccampportal/portal5/images/index/press-release17_.png", "1.jpg");
        TestThread5 t2 = new TestThread5("https://career.huawei.com/reccampportal/portal5/images/index/press-release17_.png", "2.jpg");
        TestThread5 t3 = new TestThread5("https://career.huawei.com/reccampportal/portal5/images/index/press-release17_.png", "3.jpg");

        // 1. 创建执行服务
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // 2. 提交执行
        Future<Boolean> f1 = executorService.submit(t1);
        Future<Boolean> f2 = executorService.submit(t2);
        Future<Boolean> f3 = executorService.submit(t3);

        // 3. 获取结果
        boolean res1 = f1.get();
        boolean res2 = f2.get();
        boolean res3 = f3.get();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);

        // 4. 关闭服务
        executorService.shutdownNow();
    }

    @Override
    public Boolean call() throws Exception {
        WebDownloader3 webDownloader3 = new WebDownloader3();
        webDownloader3.downloader(url, path);
        return true;
    }
}

class WebDownloader3{
    public void downloader(String url, String path){
        try {
            FileUtils.copyURLToFile(new URL(url), new File(path));
            System.out.println(path + "下载完毕！");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常！");
        }
    }
}