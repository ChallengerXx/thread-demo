package com.syn.thread;

import com.syn.SynDefectTask;
import com.syn.utils.TimeUtil;

public class SynDefectThread extends Thread {

    private SynDefectTask task;

    public SynDefectThread(SynDefectTask task) {
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
