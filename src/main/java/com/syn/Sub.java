package com.syn;


/**
 * 可重入锁也支持在父子类继承的环境中
 * 当存在父子类继承关系时，子类是完全可以通过“可重入锁”调用父类的同步方法。
 * 出现异常时，其锁持有的锁会自动释放。
 */
public class Sub extends Main {

    @Override
    public synchronized void operateIMainMethod() {
        try {
            while (i > 0) {
                i--;
                System.out.println("Sub print i =" + i);
                Thread.sleep(1000);
//                this.operateIMainMethod();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
