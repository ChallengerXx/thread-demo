package com.join;

/**
 * 不管是运行threadTest.join(2000)还是Thread.sleep(2000)， “end timer=1522036620288”语句的输出都是间隔两秒
 * 区别在于： Thread.sleep(2000)不会释放锁，threadTest.join(2000)会释放锁 。
 */
public class JoinLongTest {

    public static void main(String[] args) {

        try {
            MyThread thread = new MyThread();
            thread.start();

            thread.join(2000);
//            Thread.sleep(2000);

            System.out.println("end time =" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static public class MyThread extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("begin time =" + System.currentTimeMillis());
                Thread.sleep(10000);
                System.out.println("子线程运行结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
