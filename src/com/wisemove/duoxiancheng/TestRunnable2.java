package com.wisemove.duoxiancheng;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestRunnable2 implements Runnable{
    private final String url;
    private final String path;


    public TestRunnable2(String url, String path){
        this.url = url;
        this.path = path;
    }


    @Override
    public void run(){
        WebDownloader2 webDownloader = new WebDownloader2();
        webDownloader.download(url, path);
    }

    public static void main(String[] args) {
        TestRunnable2 tr1 = new TestRunnable2("https://career.huawei.com/reccampportal/portal5/images/index/press-release17_.png", "1.jpg");
        TestRunnable2 tr2 = new TestRunnable2("https://career.huawei.com/reccampportal/portal5/images/index/press-release17_.png", "2.jpg");
        TestRunnable2 tr3 = new TestRunnable2("https://career.huawei.com/reccampportal/portal5/images/index/press-release17_.png", "3.jpg");

        new Thread(tr1).start();
        new Thread(tr2).start();
        new Thread(tr3).start();
    }
}

class WebDownloader2{

    public void download(String url, String path){
        try {
            FileUtils.copyURLToFile(new URL(url), new File(path));
            System.out.println(path + "下载完成！");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常！");
        }
    }
}
