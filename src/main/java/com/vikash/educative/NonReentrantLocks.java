package com.vikash.educative;

class Demo{

    public static void main(String[] args) throws InterruptedException {

        NonReentrantLocks nonReentrantLocks = new NonReentrantLocks();

        nonReentrantLocks.lock();

        System.out.println("Acquired first lock");

        nonReentrantLocks.unlock();

        System.out.println("Trying to acquire second lock");

        nonReentrantLocks.lock();

        System.out.println("Acquired second lock");

        nonReentrantLocks.unlock();

        System.out.println("Released all lock");
    }
}

public class NonReentrantLocks {

    boolean isLocked;

    public NonReentrantLocks(){
        isLocked = false;
    }

    public synchronized void lock() throws InterruptedException {

        while(isLocked){
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock(){
        isLocked = false;
        notify();
    }
}
