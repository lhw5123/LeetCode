package com.hevin.other;

/**
 * 测试线程同步
 */
public class Bank {
    private volatile int mMoney = 0;

    public synchronized void add(int money) {
        mMoney += money;
        System.out.println("存入：" + money);
    }

    public synchronized void sub(int money) {
        if (mMoney - money >= 0) {
            mMoney -= money;
            System.out.println("取出：" + money);
        } else {
            System.out.println("余额不足");
        }
    }

    public synchronized int look() {
        System.out.println("账户余额：" + mMoney);
        return mMoney;
    }
}
