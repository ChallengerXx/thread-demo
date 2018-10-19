package com.join;

/**
 * join方法的作用就是主线程需要等待子线程执行完成之后再结束。
 */
public class JoinTest {

    public static void main(String[] args) throws InterruptedException {

        NoJoinTest.MyThread thread = new NoJoinTest.MyThread();
        thread.start();

//        Thread.sleep(?);//因为不知道子线程要花的时间这里不知道填多少时间
        //join方法的作用就是主线程需要等待子线程执行完成之后再结束。
        thread.join();
        System.out.println("我想当threadTest对象执行完毕后我再执行");
    }

    static public class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("我想先执行");
        }
    }
}
