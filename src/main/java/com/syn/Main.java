package com.syn;

public class Main {

    public int i = 10;

    public synchronized void operateIMainMethod() {
        try {
            i--;
            System.out.println("main print i =" + i);
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
