package com.create;

/**
 * 线程优先级具有继承特性
 */
public class PriorityThread extends Thread {

    @Override
    public void run() {
        System.out.println("PriorityThread run priority =" + this.getPriority());
        PriorityThread2 thread = new PriorityThread2();
        thread.start();
    }
}

class PriorityThread2 extends Thread {

    @Override
    public void run() {
        System.out.println("PriorityThread2 run priority =" + this.getPriority());
    }
}