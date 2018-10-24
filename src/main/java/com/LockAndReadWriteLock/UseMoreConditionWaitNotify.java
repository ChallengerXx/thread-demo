package com.LockAndReadWriteLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用多个Condition实例实现等待/通知机制：
 */
public class UseMoreConditionWaitNotify {

    public static void main(String[] args) throws InterruptedException {

        MyServiceMoreCondition serviceMoreCondition = new MyServiceMoreCondition();
        ThreadA threadA = new ThreadA(serviceMoreCondition);
        threadA.setName("A1");
        threadA.start();

        ThreadB threadB = new ThreadB(serviceMoreCondition);
        threadB.setName("B1");
        threadB.start();

        serviceMoreCondition.signalAll_A();
        System.out.println("先唤醒线程A1,等待2s");
        Thread.sleep(2000);
        System.out.println("继续唤醒线程B1");
        Thread.sleep(1000);
        serviceMoreCondition.signalAll_B();
    }

    static public class ThreadA extends Thread {
        private MyServiceMoreCondition serviceMoreCondition;

        public ThreadA(MyServiceMoreCondition serviceMoreCondition) {
            super();
            this.serviceMoreCondition = serviceMoreCondition;
        }

        @Override
        public void run() {
            serviceMoreCondition.awaitA();
        }
    }

    static public class ThreadB extends Thread {
        private MyServiceMoreCondition serviceMoreCondition;

        public ThreadB(MyServiceMoreCondition serviceMoreCondition) {
            super();
            this.serviceMoreCondition = serviceMoreCondition;
        }

        @Override
        public void run() {
            serviceMoreCondition.awaitB();
        }
    }

    static public class MyServiceMoreCondition {
        private Lock lock = new ReentrantLock();
        public Condition conditionA = lock.newCondition();
        public Condition conditionB = lock.newCondition();

        public void awaitA() {
            lock.lock();
            try {
                System.out.println("begin awaitA的时间是:" + System.currentTimeMillis()
                        + ",ThreadName =" + Thread.currentThread().getName());
                conditionA.await();
                System.out.println("end awaitA的时间是:" + System.currentTimeMillis()
                        + ",ThreadName =" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void awaitB() {
            lock.lock();
            try {
                System.out.println("begin awaitB的时间是:" + System.currentTimeMillis()
                        + ",ThreadName =" + Thread.currentThread().getName());
                conditionB.await();
                System.out.println("end awaitB的时间是:" + System.currentTimeMillis()
                        + ",ThreadName =" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void signalAll_A() {
            lock.lock();
            try {
                System.out.println("signalAll_A 的时间是:" + System.currentTimeMillis()
                        + ",ThreadName =" + Thread.currentThread().getName());
                conditionA.signalAll();
            } finally {
                lock.unlock();
            }
        }

        public void signalAll_B() {
            lock.lock();
            try {
                System.out.println("signalAll_B 的时间是:" + System.currentTimeMillis()
                        + ",ThreadName =" + Thread.currentThread().getName());
                conditionB.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}
