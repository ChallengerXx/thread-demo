package com.syn.run;

import com.syn.SynDefectTask;
import com.syn.thread.SynDefectThread;
import com.syn.thread.SynDefectThread2;
import com.syn.utils.TimeUtil;

public class SynDefectThreadRun {

    public static void main(String[] args) {
        SynDefectTask task = new SynDefectTask();

        SynDefectThread thread = new SynDefectThread(task);
        thread.start();
        SynDefectThread2 thread2 = new SynDefectThread2(task);
        thread2.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long beginTime = TimeUtil.beginTime1;
        if (TimeUtil.beginTime2 < TimeUtil.beginTime1)
            beginTime = TimeUtil.beginTime2;

        long endTime = TimeUtil.endTime1;
        if (TimeUtil.endTime2 > TimeUtil.endTime1)
            endTime = TimeUtil.endTime2;

        System.out.println("耗时：" + ((endTime - beginTime) / 1000));
    }
}
