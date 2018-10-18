package com.syn.run;

import com.syn.StaticSynService;
import com.syn.thread.StaticSynThread1;
import com.syn.thread.StaticSynThread2;
import com.syn.thread.StaticSynThread3;

/**
 * 静态同步synchronized方法与synchronized(class)代码块持有的锁一样，都是Class锁，Class锁对对象的所有实例起作用
 * synchronized关键字加到非static静态方法上持有的是对象锁。
 * 线程A,B和线程C持有的锁不一样，所以A和B运行同步，但是和C运行不同步。
 * 线程名称为：A在1539853062801进入printA
 * 线程名称为：C在1539853062802进入printC
 * 线程名称为：C在1539853062802离开printC
 * 线程名称为：A在1539853065802离开printA
 * 线程名称为：B在1539853065802进入printB
 * 线程名称为：B在1539853065802离开printB
 */
public class StaticSynThreadRun {

    public static void main(String[] args) {
        StaticSynService service = new StaticSynService();

        StaticSynThread1 thread1 = new StaticSynThread1(service);
        thread1.setName("A");
        thread1.start();
        StaticSynThread2 thread2 = new StaticSynThread2(service);
        thread2.setName("B");
        thread2.start();
        StaticSynThread3 thread3 = new StaticSynThread3(service);
        thread3.setName("C");
        thread3.start();

    }
}
