package com.create;

/**
 * 共享数据情况(线程不安全)
 */
public class ShareThread extends Thread {

    private int count = 5;

    @Override
    public void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println("由" + ShareNothingThread.currentThread().getName() + "计算，count=" + count);
        }
    }
}
