package com.LockAndReadWriteLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 第一个ReentrantLock程序
 * 结论:当一个线程运行完毕后才把锁释放，其他线程才能执行，其他线程的执行顺序是不确定的。
 */

public class ReentrantLockTest {


    public static void main(String[] args) {
        MyService myService = new MyService();

        MyThread a1 = new MyThread(myService);
        MyThread a2 = new MyThread(myService);
        MyThread a3 = new MyThread(myService);
        MyThread a4 = new MyThread(myService);
        MyThread a5 = new MyThread(myService);

        a1.start();
        a2.start();
        a3.start();
        a4.start();
        a5.start();
    }

    static public class MyService {

        private Lock lock = new ReentrantLock();

        public void testMethod() {
            lock.lock();
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("ThreadName=" + Thread.currentThread().getName() + (" " + (i + 1)));
                }
            } finally {
                lock.unlock();
            }
        }
    }

    static public class MyThread extends Thread {
        private MyService myService;

        public MyThread(MyService myService) {
            super();
            this.myService = myService;
        }

        @Override
        public void run() {
            myService.testMethod();
        }
    }
}
