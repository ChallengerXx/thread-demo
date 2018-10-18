package com.syn.run;

import com.syn.thread.AgainLockThread;

public class AgainLockThreadRun {


    public static void main(String[] args) {
        AgainLockThread thread = new AgainLockThread();
        thread.start();
    }
}
