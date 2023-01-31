package com.example.demo.mianshi.juc.futuretask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @description
 * @date 2023/1/31 11:36
 */

public class Preloader {

    public static void main(String[] args) throws Exception {
        Preloader loader = new Preloader();
        //模拟启动时就加载那些费劲的东西或逻辑
        loader.start();
        //主线程正常干自己的事
        loader.mainWork();
        //需要用到启动时的东西时，看看完成没有。没有的话，阻塞完成
        ProductInfo xx = loader.get();
        System.out.println(xx);
    }

    public void mainWork() {

    }

    ProductInfo loadProductInfo() throws Exception {
        return null;
    }

    private final FutureTask<ProductInfo> future =
            new FutureTask<ProductInfo>(new Callable<ProductInfo>() {
                public ProductInfo call() throws Exception {
                    return loadProductInfo();
                }
            });
    private final Thread thread = new Thread(future);

    public void start() {
        thread.start();
    }

    public ProductInfo get()
            throws Exception {
        try {
            return future.get();
        } catch (Exception e) {

        }
        return null;
    }

    interface ProductInfo {
    }
}
