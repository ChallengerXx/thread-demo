package com.syn.thread;

import com.syn.StaticSynService;

public class StaticSynThread3 extends Thread {

    private StaticSynService service;

    public StaticSynThread3(StaticSynService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.printC();
    }
}
