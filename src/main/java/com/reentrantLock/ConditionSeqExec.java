package com.reentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Condition实现顺序执行
 */
public class ConditionSeqExec {

    volatile private static int nextPrintWho = 1;
    private static Lock lock = new ReentrantLock();
    final private static Condition conditionA = lock.newCondition();
    final private static Condition conditionB = lock.newCondition();
    final private static Condition conditionC = lock.newCondition();


    public static void main(String[] args) {

        ThreadA threadA = new ThreadA();
        threadA.start();

        ThreadB threadB = new ThreadB();
        threadB.start();

        ThreadC threadC = new ThreadC();
        threadC.start();

    }

    public static class ThreadA extends Thread {
        @Override
        public void run() {
            lock.lock();
            try {
                while (nextPrintWho != 1) {
                    conditionA.await();
                }
                for (int i = 0; i < 3; i++) {
                    System.out.println("ThreadA" + (i + 1));
                    Thread.sleep(1000);
                }
                nextPrintWho = 2;
                //通知conditionB的线程运行
                conditionB.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static class ThreadB extends Thread {
        @Override
        public void run() {
            lock.lock();
            try {
                while (nextPrintWho != 2) {
                    conditionB.await();
                }
                for (int i = 0; i < 3; i++) {
                    System.out.println("ThreadB" + (i + 1));
                    Thread.sleep(1000);
                }
                nextPrintWho = 3;
                //通知conditionC的线程运行
                conditionC.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static class ThreadC extends Thread {
        @Override
        public void run() {
            lock.lock();
            try {
                while (nextPrintWho != 3) {
                    conditionC.await();
                }
                for (int i = 0; i < 3; i++) {
                    System.out.println("ThreadC" + (i + 1));
                    Thread.sleep(1000);
                }
                nextPrintWho = 1;
                //通知conditionA的线程运行
                conditionA.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
