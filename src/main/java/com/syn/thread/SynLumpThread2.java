package com.syn.thread;

import com.syn.SynLumpTask;
import com.syn.utils.TimeUtil;

public class SynLumpThread2 extends Thread {

    private SynLumpTask task;

    public SynLumpThread2(SynLumpTask task) {
        super();
        this.task = task;
    }

    @Override
    public void run() {
        super.run();
        TimeUtil.beginTime2 = System.currentTimeMillis();
        task.doLongTimeTask();
        TimeUtil.endTime2 = System.currentTimeMillis();
    }
}
