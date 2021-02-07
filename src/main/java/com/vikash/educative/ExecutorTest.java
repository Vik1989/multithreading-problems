package com.vikash.educative;

import java.util.concurrent.Executor;

public class ExecutorTest {
    public static void main(String[] args) {
        Executor executor = new ExecutorImpl();
        executor.execute(new Task());
    }
}

class ExecutorImpl implements Executor {

    @Override
    public void execute(Runnable command) {
        Thread t = new Thread(command);
        t.start();
    }
}
class Task implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
