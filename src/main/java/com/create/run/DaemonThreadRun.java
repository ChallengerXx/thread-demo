package com.create.run;

import com.create.DaemonThread;

public class DaemonThreadRun {

    public static void main(String[] args) throws InterruptedException {
        DaemonThread thread = new DaemonThread();
        //setDaemon(true)必须在start（）方法前执行，否则会抛出IllegalThreadStateException异常
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(5000);
        System.out.println("我离开thread对象也不再打印了，也就是停止了！");
    }
}
