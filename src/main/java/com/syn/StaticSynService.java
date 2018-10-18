package com.syn;

/**
 * 静态同步synchronized方法与synchronized(class)代码块
 * synchronized关键字加到static静态方法和synchronized(class)代码块上都是是给Class类上锁，而synchronized关键字加到非static静态方法上是给对象上锁。
 */
public class StaticSynService {

    public static void printA() {
        synchronized (StaticSynService.class) {
            try {
                System.out.println("线程名称为：" + Thread.currentThread().getName() + "在"
                        + System.currentTimeMillis() + "进入printA");
                Thread.sleep(3000);
                System.out.println("线程名称为：" + Thread.currentThread().getName() + "在"
                        + System.currentTimeMillis() + "离开printA");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    synchronized public static void printB(){
        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入printB");
        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "离开printB");
    }
    synchronized public void printC(){
        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入printC");
        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "离开printC");
    }
}
