package com.vikash.educative;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocks {
    Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        ReentrantLock reentrantLocks = new ReentrantLock();

        reentrantLocks.lock();

        System.out.println("Acquiring second lock");

        reentrantLocks.lock();

        System.out.println("Acquiring second lock");
    }



}
