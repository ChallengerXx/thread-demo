package com.syn.thread;

import com.syn.SynLumpTask;
import com.syn.utils.TimeUtil;

public class SynLumpThread extends Thread {

    private SynLumpTask task;

    public SynLumpThread(SynLumpTask task) {
        super();
        this.task = task;
    }

    @Override
    public void run() {
        super.run();
        TimeUtil.beginTime1 = System.currentTimeMillis();
        task.doLongTimeTask();
        TimeUtil.endTime1 = System.currentTimeMillis();
    }
}
