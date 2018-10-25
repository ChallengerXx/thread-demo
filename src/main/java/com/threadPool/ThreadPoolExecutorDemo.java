package com.threadPool;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {
        //创建一个FixedPoolPool对象
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            //创建ThreadA对象（ThreadA对象实现Runnable接口）
            ThreadA threadA = new ThreadA("" + i);
            //执行Runnable
            executor.execute(threadA);
        }
        //终止线程池
        executor.shutdown();
        while (!executor.isTerminated()) {
            //等待所有任务完成
        }
        System.out.println("Finished all threads");
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
