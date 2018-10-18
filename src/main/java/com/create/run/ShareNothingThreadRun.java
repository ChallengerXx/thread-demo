package com.create.run;

import com.create.ShareNothingThread;


public class ShareNothingThreadRun {

    public static void main(String[] args) {
        ShareNothingThread thread = new ShareNothingThread("A");
        ShareNothingThread thread1 = new ShareNothingThread("B");
        ShareNothingThread thread2 = new ShareNothingThread("C");
        thread.start();
        thread1.start();
        thread2.start();
    }
}
