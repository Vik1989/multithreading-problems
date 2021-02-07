package com.vikash.educative;

class DeadlockRunner{

    public static void main(String[] args) throws InterruptedException {

        Deadlock deadlock = new Deadlock();

        deadlock.runTest();
    }
}
public class Deadlock {

    public int counter = 0;

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void runTest() throws InterruptedException {

        Runnable run1 = () -> {
            try {
                increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable run2 = () -> {
            try {
                decrement();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread t1 = new Thread(run1);
        Thread t2 = new Thread(run2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Completed");
    }

    public void increment() throws InterruptedException {
        synchronized (lock1){
            System.out.println("In thread 1");
            Thread.sleep(10);
            synchronized (lock2){

            }
        }
    }

    public void decrement() throws InterruptedException {
        synchronized (lock2){
            System.out.println("In thread 2");
            Thread.sleep(10);
            synchronized (lock1){

            }
        }
    }

}
