package com.volatiles.thread;

/**
 * volatile无法保证变量原子性
 * 使用synchronized关键字加锁,要保证数据的原子性还是要使用synchronized关键字。
 */
public class VolaAtomThread extends Thread {

    public volatile static int count = 0;

    private /*synchronized*/ static void addCount() {
        for (int i = 0; i < 100; i++) {
            count = i;
        }
        System.out.println("count =" + count);
    }

    @Override
    public void run() {
        addCount();
    }
}
