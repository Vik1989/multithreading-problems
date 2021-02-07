package com.vikash.educative;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionSignalling {

    public static void main(String[] args) throws InterruptedException {

        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition condition = reentrantLock.newCondition();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                reentrantLock.lock();
                condition.signal();
                System.out.println("Signal sent");
                reentrantLock.unlock();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                reentrantLock.lock();
                boolean conditionMet = false;
                try {
                    System.out.println("Awaiting Signal");
                    while(!conditionMet) {
                        condition.await();
                        conditionMet = true;
                    }
                    System.out.println("Received Signal");
                    reentrantLock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}

