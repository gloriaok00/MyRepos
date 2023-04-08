package com.example.demo.mm.thread.manyget2;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import lombok.extern.slf4j.Slf4j;

/**
 *  @description many get测试
 *  @date  2023/4/7 22:31
 */

@Slf4j
public class MGDemo {

    //private static ExecutorService pool=Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        System.out.println("1");
        Thread t1=new Thread(()->{
            System.out.println("222");
            HttpResponse resp = HttpRequest.get("https://www.google.com/complete/search?q=model%203&cp=0&client=desktop-gws-wiz-on-focus-serp&xssi=t&hl=zh-CN&authuser=0&pq=model%203&psi=HjMwZO6xOeWZkPIPg76YmAI.1680880417035&dpr=2&ofp=EAEyxQEKFQoTbW9kZWwgM-S7t-agvOS4reWbvQoVChN0ZXNsYSBtb2RlbCAz5Lu35qC8Cg8KDW1vZGVsIDPkuK3lm70KFQoTbW9kZWwgM-S4iuW4guaXtumXtAoVChN0ZXNsYSBtb2RlbCAz5Lit5Zu9CgcKBVRlc2xhCg8KDW1vZGVsIDPlsLrlr7gKDwoNVGVzbGEgTW9kZWwgWQoPCg1tb2RlbCAz5pS55qy-ChgKFueJueaWr-aLiW1vZGVsIDPku7fmoLwQRzJwCiUKI0hvdyBtdWNoIHdpbGwgYSBUZXNsYSBNb2RlbCAzIGNvc3Q_Ch8KHVdoeSBhcmUgVGVzbGEgMyBzbyBleHBlbnNpdmU_CiMKIUlzIFRlc2xhIE1vZGVsIDMgcmVhbGx5IHdvcnRoIGl0PxDkAg&newwindow=1").execute();
            //HttpResponse resp = HttpRequest.get("https://www.baidu.com/s?ie=utf-8&csq=1&pstg=20&mod=2&isbd=1&cqid=8ae71ce300040b57&istc=2600&ver=0QgaGwJU0eTaje7fofTZye9Z00BrZCmVEIi&chk=643034fb&isid=4845653D55673710&wd=model%203&rsv_spt=1&rsv_iqid=0x88ae7cfd0003c526&issp=1&f=3&rsv_bp=1&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=1&rsv_dl=ts_2&rsv_sug3=5&rsv_sug1=3&rsv_sug7=100&rsv_t=79ddjWtcta8MtHF32mW8QsxNoQz4snJxYNd8%2Bxml9Yy4zV0m9Nxn0nP8nyU%2BM1jRoGJS&rsv_sug2=1&rsv_btype=i&prefixsug=mode&rsp=2&inputT=6162&rsv_sug4=6163&f4s=1&_ck=1360.0.-1.-1.-1.-1.-1&rsv_isid=38185_36552_38409_38470_38366_38303_38468_38289_37937_38386_26350_38420_38282_37881&isnop=1&rsv_stat=-2&rsv_bp=1").execute();
            log.info("后台管理系统注册结果:" + resp.body());
            //throw new RuntimeException();
        });
        t1.setUncaughtExceptionHandler((Thread thread1, Throwable e) -> {
            System.out.println("线程工厂设置的exceptionHandler" + e.getMessage());
        });
        t1.start();
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
    }
}
