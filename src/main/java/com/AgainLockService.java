package com;

/**
 * synchronized锁重入
 * 自己可以再次获取自己的内部锁
 */
public class AgainLockService {

    public synchronized void service1() {
        System.out.println("service1");
        service2();
    }

    public synchronized void service2() {
        System.out.println("service2");
        service3();
    }

    public synchronized void service3() {
        System.out.println("service3");
    }
}
