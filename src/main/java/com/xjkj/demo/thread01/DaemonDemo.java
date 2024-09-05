package com.xjkj.demo.thread01;


/**
 * @author tqq
 * @date 2024-07-12 15:44:25
 */
public class DaemonDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName() +"\t 开始运行，"
                    +(Thread.currentThread().isDaemon()?"守护线程":"用户线程"));
            while (true){

            }
        },"t1");
//        t1.setDaemon(true);
        t1.start();
        Thread.sleep(1000);

        System.out.println(Thread.currentThread().getName() +"\t 结束运行，");
    }
}
