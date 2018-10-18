package com.create;


public class InterruptThread extends Thread {

    /**
     * for循环虽然停止执行了，但是for循环下面的语句还是会执行，说明线程并未被停止。
     */
//    @Override
//    public void run() {
//        super.run();
//        for (int i = 0; i < 5000000; i++) {
//            if (this.isInterrupted()) {
//                System.out.println("已经是停止状态了，退出！");
//                break;
//            }
//            System.out.println("i =" + (i + 1));
//        }
//        System.out.println("并没有退出！");
//    }

    /**
     * 使用return停止线程
     */
    @Override
    public void run() {
        for (int i = 0; i < 5000000; i++) {
            if (this.isInterrupted()) {
                System.out.println("已经是停止状态了，退出！");
                return;
            }
            System.out.println("i =" + (i + 1));
        }
        System.out.println("并没有退出！");
    }
}
