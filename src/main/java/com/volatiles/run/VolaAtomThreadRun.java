package com.volatiles.run;

import com.volatiles.thread.VolaAtomThread;

/**
 * 打印结果
 * count =99
 * count =99
 * count =42
 * count =99
 * count =99
 * 总结：volatile无法保证对变量原子性的。
 */
public class VolaAtomThreadRun {

    public static void main(String[] args) {
        VolaAtomThread[] threads = new VolaAtomThread[100];

        for (int i = 0; i < 100; i++) {
            threads[i] = new VolaAtomThread();
        }
        for (int i = 0; i < 100; i++) {
            threads[i].start();
        }
    }
}
