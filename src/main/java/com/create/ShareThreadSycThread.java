package com.create;

/**
 * 共享数据情况（synchronized线程安全）
 */
public class ShareThreadSycThread extends Thread {

    private int count = 5;

    @Override
    public synchronized void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println("由" + ShareNothingThread.currentThread().getName() + "计算，count=" + count);
        }
    }
}
