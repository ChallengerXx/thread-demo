package com.volatiles.thread;

/**
 * volatile 修饰的成员变量在每次被线程访问时，都强迫从主存（共享内存）中重读该成员变量的值
 * 当成员变量发生变化时，强迫线程将变化值回写到主存（共享内存）
 * 在任何时刻，两个不同的线程总是看到某个成员变量的同一个值，
 * 保证了同步数据的可见性。
 */
public class CycleThread extends Thread {

    private /*volatile*/ boolean isRunning = true;
    int m;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    @Override
    public void run() {
        System.out.println("进入run方法了");
        while (isRunning) {
            m = 5;

            /**
             * 假如你把while循环代码里加上任意一个输出语句或者sleep方法你会发现死循环也会停止，不管isRunning变量是否被加上了上volatile关键字。
             * JVM会尽力保证内存的可见性，即便这个变量没有加同步关键字.只要CPU有时间，JVM会尽力去保证变量值的更新。
             * volatile关键字会强制的保证线程的可见性。不加这个关键字，JVM也会尽力去保证可见性
             * 最开始的代码，一直处于死循环中，CPU处于一直占用的状态，这个时候CPU没有时间，JVM也不能强制要求CPU分点时间去取最新的变量值。
             * 加了输出或者sleep语句之后，CPU就有可能有时间去保证内存的可见性，于是while循环可以被终止。
             */
//            System.out.println("打印一下");
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

        }
        System.out.println(m);
        System.out.println("线程被停止了");
    }
}
