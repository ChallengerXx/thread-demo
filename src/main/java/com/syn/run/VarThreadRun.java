package com.syn.run;

import com.syn.PublicVar;
import com.syn.thread.VarThread;

public class VarThreadRun {

    public static void main(String[] args) throws InterruptedException {
        PublicVar publicVar = new PublicVar();
        VarThread thread = new VarThread(publicVar);

        thread.start();
        //打印结果受此值结果影响
        Thread.sleep(100);

        publicVar.getValue();
    }
}
