package com.LockAndReadWriteLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁与非公平锁
 */
public class FairOrNoFairLock {

    public static void main(String[] args) throws InterruptedException {
        //true公平、false不公平
        boolean isFair = false;
        Service service = new Service(isFair);
        for (int i = 0; i < 5; i++) {
            MyThread thread = new MyThread(service);
            thread.setName("Thread" + (i + 1));
            thread.start();
        }
    }

    static public class MyThread extends Thread {
        private Service service;

        public MyThread(Service service) {
            super();
            this.service = service;
        }

        @Override
        public void run() {
            System.out.println("线程:" + Thread.currentThread().getName() + "运行了");
            service.serviceMethod();
        }
    }

    static public class Service {
        private ReentrantLock lock;

        public Service(boolean isFair) {
            super();
            this.lock = new ReentrantLock(isFair);
        }

        public void serviceMethod() {
            lock.lock();
            try {
                System.out.println("ThreadName:" + Thread.currentThread().getName() + "获得锁定");
            } finally {
                lock.unlock();
            }
        }
    }
}
