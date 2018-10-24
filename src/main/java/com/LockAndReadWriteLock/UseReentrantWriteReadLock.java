package com.LockAndReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读读共享
 * 两个线程同时运行read方法，你会发现两个线程可以同时或者说是几乎同时运行lock()方法后面的代码，输出的两句话显示的时间一样。这样提高了程序的运行效率。
 * -----------------------------
 * 写写互斥 :把lock.readLock().lock(); 改为 lock.writeLock().lock();
 * 两个线程同时运行read方法，同一时间只允许一个线程执行lock()方法后面的代码
 */
public class UseReentrantWriteReadLock {

    public static void main(String[] args) throws InterruptedException {
        //读读共享和写写互斥
        Service service = new Service();
        ThreadA threadA = new ThreadA(service);
        ThreadB threadB = new ThreadB(service);

        threadA.start();
        threadB.start();

        //读写互斥
        Service service1 = new Service();
        ThreadA threadA1 = new ThreadA(service1);
        ThreadC threadC1 = new ThreadC(service1);

        threadA1.start();
        Thread.sleep(1000);
        threadC1.start();

    }

    static public class ThreadA extends Thread {
        private Service service;

        public ThreadA(Service service) {
            super();
            this.service = service;
        }

        @Override
        public void run() {
            service.read();
        }
    }

    static public class ThreadB extends Thread {
        private Service service;

        public ThreadB(Service service) {
            this.service = service;
        }

        @Override
        public void run() {
            service.read();
        }
    }

    static public class ThreadC extends Thread {
        private Service service;

        public ThreadC(Service service) {
            super();
            this.service = service;
        }

        @Override
        public void run() {
            service.write();
        }
    }

    static public class Service {
        private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        public void read() {
            try {
                try {
                    lock.readLock().lock();
                    System.out.println("获得读锁:" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
                    Thread.sleep(2000);
                } finally {
                    lock.readLock().unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void write() {
            try {
                try {
                    lock.writeLock().lock();
                    System.out.println("获得写锁:" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
                    Thread.sleep(2000);
                } finally {
                    lock.writeLock().unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
