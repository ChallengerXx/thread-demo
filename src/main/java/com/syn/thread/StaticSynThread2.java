package com.syn.thread;

import com.syn.StaticSynService;

public class StaticSynThread2 extends Thread {

    private StaticSynService service;

    public StaticSynThread2(StaticSynService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.printB();
    }
}
