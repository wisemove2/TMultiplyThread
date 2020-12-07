package com.wisemove.duoxiancheng;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestThread02 extends Thread{
    private final String url;
    private final String path;

    public TestThread02(String url, String path) {
        this.url = url;
        this.path = path;
    }

    @Override
    public void run(){
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, path);
    }

    public static void main(String[] args) {
        TestThread02 t1 = new TestThread02("https://career.huawei.com/reccampportal/portal5/images/index/press-release17_.png", "1.jpg");
        TestThread02 t2 = new TestThread02("https://career.huawei.com/reccampportal/portal5/images/index/press-release17_.png", "2.jpg");
        TestThread02 t3 = new TestThread02("https://career.huawei.com/reccampportal/portal5/images/index/press-release17_.png", "3.jpg");

        t1.start();
        t2.start();
        t3.start();

    }


}


class WebDownloader{
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