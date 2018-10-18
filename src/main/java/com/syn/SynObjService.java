package com.syn;

import com.syn.bean.MyObject;

/**
 * synchronized（object）代码块间使用
 */
public class SynObjService {

    public void testMethod(MyObject object) {
        synchronized (object) {
            try {
                System.out.println("testMethod getLock time =" + System.currentTimeMillis()
                        + ", run ThreadName =" + Thread.currentThread().getName());
                Thread.sleep(2000);
                System.out.println("testMethod releaseLock time =" + System.currentTimeMillis()
                        + ", run ThreadName =" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
