package com.syn.run;

import com.syn.SynLumpTask;
import com.syn.thread.SynLumpThread;
import com.syn.thread.SynLumpThread2;
import com.syn.utils.TimeUtil;

public class SynLumpThreadRun {

    public static void main(String[] args) {
        SynLumpTask task = new SynLumpTask();

        SynLumpThread thread = new SynLumpThread(task);
        thread.start();
        SynLumpThread2 thread2 = new SynLumpThread2(task);
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
