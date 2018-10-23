package com.threadLocal;


import java.util.Date;

/**
 * 验证线程变量间的隔离性
 */
public class Test3 {

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("在Main线程中取值=" + Tools.t1.get());
                Thread.sleep(100);
            }
            Thread.sleep(500);
            ThreadA threadA = new ThreadA();
            threadA.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static public class Tools {

        public static ThreadLocalExt t1 = new ThreadLocalExt();
    }

    static public class ThreadLocalExt extends ThreadLocal {

        @Override
        protected Object initialValue() {
            return new Date().getTime();
        }
    }

    static public class ThreadA extends Thread {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("从ThreadA线程中取值:" + Tools.t1.get());
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
