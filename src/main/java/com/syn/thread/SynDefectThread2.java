package com.syn.thread;

import com.syn.SynDefectTask;
import com.syn.utils.TimeUtil;

public class SynDefectThread2 extends Thread {

    private SynDefectTask task;

    public SynDefectThread2(SynDefectTask task) {
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
