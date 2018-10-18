package com.run;

import com.create.ShareThreadSycThread;

public class ShareThreadSycThreadRun {

    public static void main(String[] args) {
        ShareThreadSycThread thread = new ShareThreadSycThread();
        Thread thread1 = new Thread(thread,"A");
        Thread thread2 = new Thread(thread,"B");
        Thread thread3 = new Thread(thread,"C");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
