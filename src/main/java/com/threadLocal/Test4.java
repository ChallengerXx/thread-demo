package com.threadLocal;

import java.util.Date;

/**
 * 取到父线程的ThreadLocal类的变量，InheritableThreadLocal类
 * 注意:如果子线程在取得值的同时，主线程将InheritableThreadLocal中的值进行更改，那么子线程取到的还是旧值。
 */
public class Test4 {
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

        public static InheritableThreadLocalExt t1 = new InheritableThreadLocalExt();

    }

    static public class InheritableThreadLocalExt extends InheritableThreadLocal {

        @Override
        protected Object initialValue() {
            return new Date().getTime();
        }

        @Override
        protected Object childValue(Object parentValue) {
            return parentValue + "我在子线程加的";
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
