package com.syn.thread;

import com.syn.AgainLockService;

public class AgainLockThread extends Thread {

    @Override
    public void run() {
        AgainLockService service = new AgainLockService();
        service.service1();
    }
}
