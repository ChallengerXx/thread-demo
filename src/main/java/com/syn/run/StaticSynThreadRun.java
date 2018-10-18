package com.syn.run;

import com.syn.StaticSynService;
import com.syn.thread.StaticSynThread1;
import com.syn.thread.StaticSynThread2;
import com.syn.thread.StaticSynThread3;

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
