package com.volatiles.run;

import com.volatiles.thread.CycleThread;

/**
 * RunThread类中的isRunning变量没有加上volatile关键字时，运行以上代码会出现死循环，这是因为isRunning变量虽然被修改但是没有被写到主存中，
 * 这也就导致该线程在本地内存中的值一直为true，这样就导致了死循环的产生。
 */
public class CycleThreadRun {

    public static void main(String[] args) throws InterruptedException {
        CycleThread thread = new CycleThread();

        thread.start();
        Thread.sleep(1000);
        thread.setRunning(false);
        System.out.println("已经赋值为false");
    }
}
