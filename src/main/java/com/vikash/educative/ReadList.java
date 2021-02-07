package com.vikash.educative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadList {

    public static void main(String[] args) throws InterruptedException {

        List<Integer> numlist = Arrays.asList(new Integer[]{1,2,3,4,5,6});

        Runnable t1 = () -> {
            System.out.println("Thread is "+ Thread.currentThread().getName());
            System.out.println(numlist.stream().filter( a -> a <= numlist.size()/2).mapToInt(a -> a).summaryStatistics());
        };

        Runnable t2 = () -> {
            System.out.println("Thread is "+ Thread.currentThread().getName());
            System.out.println(numlist.stream().filter( a -> a >= numlist.size()/2).mapToInt(a -> a).summaryStatistics());
        };

        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Completed");
    }
}
