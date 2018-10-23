package com.threadLocal;

/**
 * 初试ThreadLocal
 */
public class Test1 {

    public static ThreadLocal<String> t1 = new ThreadLocal<>();

    public static void main(String[] args) {
        if (t1.get() == null) {
            System.out.println("为ThreadLocal放入值:123");
            t1.set("123");
        }
        System.out.println(t1.get());
    }
}
