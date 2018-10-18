package com.syn.thread;

import com.syn.PublicVar;

public class VarThread extends Thread {

    private PublicVar publicVar;

    public VarThread(PublicVar publicVar) {
        super();
        this.publicVar = publicVar;
    }

    @Override
    public void run() {
        super.run();
        publicVar.setValue("123", "456");
    }
}
