package com.threadPool;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorDemo {

    public static void main(String[] args) throws InterruptedException {

        //创建一个ScheduledThreadPoolExecutor对象
        ScheduledThreadPoolExecutor scheduledThreadPool = new ScheduledThreadPoolExecutor(5);
        System.out.println("Current time =" + new Date());

        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            ThreadA threadA = new ThreadA("do heavy processing");
            //创建并执行在给定延迟后启用的单次操作
//            scheduledThreadPool.schedule(threadA, 10, TimeUnit.SECONDS);
            //创建并执行在给定延迟后运行,然后在给定的时间段内运行。
//            scheduledThreadPool.scheduleAtFixedRate(threadA, 0, 10, TimeUnit.SECONDS);
            //初始延迟启动周期性执行，然后以给定延迟执行。 延迟时间是线程完成执行的时间。
            scheduledThreadPool.scheduleWithFixedDelay(threadA, 0, 1, TimeUnit.SECONDS);
        }

        //添加一些延迟让调度程序产生一些线程
        Thread.sleep(30000);
        System.out.println("Current time =" + new Date());
        //关闭线程池
        scheduledThreadPool.shutdown();
        while (!scheduledThreadPool.isTerminated()) {
            //等待所有任务完成
        }
        System.out.println("Finish all threads");
    }

    public static class ThreadA implements Runnable {
        private String command;

        public ThreadA(String command) {
            this.command = command;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ", start, time=" + new Date());
            processCommand();
            System.out.println(Thread.currentThread().getName() + ", end, time=" + new Date());
        }

        private void processCommand() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return this.command;
        }
    }
}
