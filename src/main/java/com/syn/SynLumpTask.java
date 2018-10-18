package com.syn;

/**
 * synchronized 代码块优化synchronized方法
 * 当一个线程访问一个对象的synchronized同步代码块时，另一个线程任然可以访问该对象非synchronized同步代码块。
 * 不在synchronized代码块中就异步执行，在synchronized代码块中就是同步执行。
 */
public class SynLumpTask {

    private String getData1;
    private String getData2;

    public void doLongTimeTask() {
        try {
            System.out.println("begin task");
            Thread.sleep(3000);
            getData1 = "长时间处理任务后从远程返回的值1 threadName =" + Thread.currentThread().getName();
            getData2 = "长时间处理任务后从远程返回的值2 threadName =" + Thread.currentThread().getName();
            synchronized (this) {
                System.out.println(getData1);
                System.out.println(getData2);
            }
            System.out.println("end task");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
