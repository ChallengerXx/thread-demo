package com.syn.thread;

import com.syn.StaticSynService;

public class StaticSynThread1 extends Thread {

    private StaticSynService service;

    public StaticSynThread1(StaticSynService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.printA();
    }
}
