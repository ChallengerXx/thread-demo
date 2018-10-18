package com.syn.thread;

import com.syn.Sub;

public class SubThread extends Thread {

    @Override
    public void run() {
        Sub sub = new Sub();
        sub.operateIMainMethod();
    }
}
