package com.syn.run;

import com.syn.thread.SubThread;

public class SubThreadRun {

    public static void main(String[] args) {
        SubThread thread = new SubThread();
        thread.start();
    }
}
