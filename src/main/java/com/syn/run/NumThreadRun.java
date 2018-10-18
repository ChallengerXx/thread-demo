package com.syn.run;

import com.syn.HasSelfPrivateNum;
import com.syn.thread.NumThread1;
import com.syn.thread.NumThread2;

/**
 * 两个线程Thread1和Thread2分别访问同一个类的不同实例的相同名称的同步方法，但是效果确实异步执行。
 * 创建了两个HasSelfPrivateNum类对象，所以就产生了两个锁
 */
public class NumThreadRun {

    public static void main(String[] args) {
        HasSelfPrivateNum numRef1 = new HasSelfPrivateNum();
        HasSelfPrivateNum numRef2 = new HasSelfPrivateNum();

        NumThread1 thread1 = new NumThread1(numRef1);
        thread1.start();
        NumThread2 thread2 = new NumThread2(numRef2);
        thread2.start();
    }
}
