package com.syn.thread;

import com.syn.SynObjService;
import com.syn.bean.MyObject;

public class SynObjThread1 extends Thread {

    private SynObjService service;
    private MyObject object;

    public SynObjThread1(SynObjService service, MyObject object) {
        super();
        this.service = service;
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        service.testMethod(object);
    }
}
