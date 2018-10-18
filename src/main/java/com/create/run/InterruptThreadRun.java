package com.create.run;

import com.create.InterruptThread;

public class InterruptThreadRun {

    public static void main(String[] args) {
        InterruptThread thread = new InterruptThread();
        thread.start();
        try {
            Thread.sleep(10000);
            thread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
    }
}
