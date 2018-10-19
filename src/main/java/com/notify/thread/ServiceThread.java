package com.notify.thread;

import com.notify.Service;

/**
 * 当线程呈wait状态时，对线程对象调用interrupt方法会出现InterrupedException异常。
 */
public class ServiceThread extends Thread {

    private Object lock;

    public ServiceThread(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        Service service = new Service();
        service.testMethod(lock);
    }
}
