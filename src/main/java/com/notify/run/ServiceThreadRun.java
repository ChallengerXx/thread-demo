package com.notify.run;

import com.notify.thread.ServiceThread;

public class ServiceThreadRun {

    public static void main(String[] args) {
        try {
            Object lock = new Object();
            ServiceThread thread = new ServiceThread(lock);
            thread.start();
            Thread.sleep(2000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
