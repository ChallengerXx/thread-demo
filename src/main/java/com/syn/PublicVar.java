package com.syn;


/**
 * 多线程可能脏读实例
 */
public class PublicVar {

    public String userName = "username";
    public String password = "password";

    synchronized public void setValue(String userName, String password) {
        try {
            this.userName = userName;
            Thread.sleep(5000);
            this.password = password;

            System.out.println("setValue method thread name =" + Thread.currentThread().getName()
                    + ", userName =" + userName + ", password =" + password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //该方法前加上synchronized关键字就同步了
    /*synchronized*/
    public void getValue() {
        System.out.println("getValue method thread name =" + Thread.currentThread().getName()
                + ", userName =" + userName + ", password =" + password);
    }
}
