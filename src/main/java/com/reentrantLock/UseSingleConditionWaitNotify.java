package com.reentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用单个Condition实例实现等待/通知机制：
 */
public class UseSingleConditionWaitNotify {

    public static void main(String[] args) throws InterruptedException {

        MyService myService = new MyService();

        ThreadA threadA = new ThreadA(myService);
        threadA.start();
        Thread.sleep(1000);
        myService.signal();
    }

    static public class MyService {

        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public void await() {
            lock.lock();
            try {
                System.out.println("await的时间为:" + System.currentTimeMillis());
                condition.await();
                System.out.println("这是condition.await()方法之后的语句,condition.signal()方法之后我才执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void signal() throws InterruptedException {
            lock.lock();
            try {
                System.out.println("signle的时间为:" + System.currentTimeMillis());
                condition.signal();
                System.out.println("这是condition.signal()方法之后的语句");
            } finally {
                lock.unlock();
            }
        }
    }

    static public class ThreadA extends Thread {
        private MyService myService;

        public ThreadA(MyService myService) {
            super();
            this.myService = myService;
        }

        @Override
        public void run() {
            myService.await();
        }
    }
}
