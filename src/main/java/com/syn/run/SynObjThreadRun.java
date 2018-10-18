package com.syn.run;

import com.syn.SynObjService;
import com.syn.bean.MyObject;
import com.syn.thread.SynObjThread1;
import com.syn.thread.SynObjThread2;

/**
 * 如果两个线程使用了同一个“对象监视器”,运行结果同步，否则不同步.
 */
public class SynObjThreadRun {

    public static void main(String[] args) {
        MyObject object = new MyObject();
        SynObjService service = new SynObjService();
        //两个线程使用了不同的“对象监视器”,所以运行结果不是同步的了。
//        MyObject object1 = new MyObject();

        SynObjThread1 thread1 = new SynObjThread1(service, object);
        thread1.setName("a");
        thread1.start();
        SynObjThread2 thread2 = new SynObjThread2(service, object);
        thread2.setName("b");
        thread2.start();
    }
}
