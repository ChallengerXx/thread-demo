package com.threadLocal;

public class Test2 {

    public static ThreadLocalExt t1 = new ThreadLocalExt();

    public static void main(String[] args) {
        if (t1.get() == null) {
            System.out.println("没放过值");
            t1.set("我的值");
        }
        System.out.println(t1.get());
    }

    public static class ThreadLocalExt extends ThreadLocal {

        @Override
        protected Object initialValue() {
            return "我是默认值，第一次get()不再为空";
        }
    }
}
