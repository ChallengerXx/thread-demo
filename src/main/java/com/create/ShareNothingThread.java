package com.create;

/**
 * 不共享数据情况
 */
public class ShareNothingThread extends Thread {

    private int count = 5;

    public ShareNothingThread(String name) {
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println("由" + ShareNothingThread.currentThread().getName() + "计算，count=" + count);
        }
    }
}
