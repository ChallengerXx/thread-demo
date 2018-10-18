package com.syn.thread;

import com.syn.HasSelfPrivateNum;

public class NumThread2 extends Thread {

    private HasSelfPrivateNum numRef;

    public NumThread2(HasSelfPrivateNum numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("b");
    }
}
