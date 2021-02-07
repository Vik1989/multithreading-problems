package com.vikash.educative;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorThreadPool {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        try {
            for (int i = 0; i <= 100; i++) {

                System.out.println("Submitting task " + i);
                executor.execute(new Task());
            }
        }finally {
            System.out.println("Maximum threads inside pool " + executor.getPoolSize());
            executor.shutdown();
        }
    }
}

class ThreadPoolExecutorTest implements Executor{

    @Override
    public void execute(Runnable command) {
        Thread t1 = new Thread(command);
        t1.start();
    }
}