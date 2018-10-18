package com.syn;

/**
 * 字符串常量池中的字符串只存在一份
 * synchronized(“abc”)修饰的方法时，这两个线程就会持有相同的锁，导致某一时刻只有一个线程能运行。
 */
public class StringSynService {

    public void testMethod(){
        synchronized ("abc"){
            System.out.println("方法__testMethod");
        }
    }

    public void testMethod2(){
        synchronized ("abc"){
            System.out.println("方法__testMethod2");
        }
    }

}
