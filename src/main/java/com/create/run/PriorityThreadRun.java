package com.create.run;

import com.create.PriorityThread;

public class PriorityThreadRun {

    public static void main(String[] args) {
        System.out.println("main thread begin priority =" + Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(6);
        System.out.println("main thread end priority =" + Thread.currentThread().getPriority());
        PriorityThread thread = new PriorityThread();
        thread.start();
    }
}
