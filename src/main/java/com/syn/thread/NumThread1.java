package com.syn.thread;

import com.syn.HasSelfPrivateNum;

public class NumThread1 extends Thread {

    private HasSelfPrivateNum numRef;

    public NumThread1(HasSelfPrivateNum numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("a");
    }
}
