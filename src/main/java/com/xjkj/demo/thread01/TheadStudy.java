package com.xjkj.demo.thread01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author tqq
 * @date 2024-07-12 16:55:21
 */
public class TheadStudy {
    public static void main(String[] args) {
        //1.匿名子类
        StringBuffer sb = new StringBuffer();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                sb.append("a".repeat(5));
            }
        };

        //2.实现Runnable接口
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                sb.append("a".repeat(5));
            };
        });

        //3.实现Callable接口
        Thread t3 = new Thread(new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                sb.append("a".repeat(5));
                return sb.toString();
            };
        }));

        //4.线程池
//        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                String[] s= {"@","#","$","%","！"};
//                for (String string : s) {
//                    sb.append(string);
//                }
//            }
//        });

        try {
            t1.join();  // 等待 t1 执行完毕
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.start();

        System.out.println(sb);
    }
}
