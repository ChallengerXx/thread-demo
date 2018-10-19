package com.notify.run;

import com.notify.thread.ThreadA;
import com.notify.thread.ThreadB;

/**
 * wait begin =1539915323338
 * 添加了1个元素
 * 添加了2个元素
 * 添加了3个元素
 * 添加了4个元素
 * 已发出通知！
 * 添加了5个元素
 * 添加了6个元素
 * 添加了7个元素
 * 添加了8个元素
 * 添加了9个元素
 * 添加了10个元素
 * wait end =1539915333393
 * 总结：notify()执行后并不会立即释放锁。
 */
public class MyListThreadRun {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        ThreadA threadA = new ThreadA(lock);
        ThreadB threadB = new ThreadB(lock);

        threadA.start();
        Thread.sleep(50);
        threadB.start();
    }
}
