package com.vikash.educative;

import java.util.concurrent.Semaphore;

public class SemaphoreSignalling {

    public static void main(String[] args) throws InterruptedException {

        final Semaphore semaphore = new Semaphore(1);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore.acquire();
                    System.out.println("Thread 1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                boolean acquire = false;

                while(!acquire){
                    try {
                        semaphore.acquire();
                        acquire = true;
                        System.out.println("Thread 2");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        semaphore.release();
                    }
                }
            }
        });

        t1.start();
        t2.start();

        System.out.println("main exit");
    }
}
