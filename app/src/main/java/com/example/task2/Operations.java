package com.example.task2;

import android.util.Log;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Handler;

public class Operations {
    public static ArrayList<String> arrayList = new ArrayList<>();
    public static String addToStartArraylistResult;
    public static String addToMiddleArraylistResult;
    public static String addToEndArraylistResult;

    public static void myThreads() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(new CreateLists());
        addToStartArraylistResult = "Adding to start in ArrayList: \n"
                + executorService.submit(new AddToStartArraylist()).get() + " ms";
        addToMiddleArraylistResult = "Adding to middle of ArrayList: \n"
                + executorService.submit(new AddToMiddleArraylist()).get() + " ms";
        addToEndArraylistResult = "Adding to end of ArrayList: \n"
                + executorService.submit(new AddToEndArraylist()).get() + " ms";


        executorService.shutdown();
    }

    static class CreateLists implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 500000; i++){
                arrayList.add(i+"");
            }
        }
    }

    static class AddToStartArraylist implements Callable{
        @Override
        public String call() throws Exception {
            double timeAtStart = System.nanoTime();
            arrayList.add(0, "123");
            return String.valueOf((System.nanoTime() - timeAtStart)/1_000_000.0);
        }


    }

    static class AddToMiddleArraylist implements Callable{
        @Override
        public String call() throws Exception {
            double timeAtStart = System.nanoTime();
            arrayList.add(arrayList.size()/2, "123");
            return String.valueOf((System.nanoTime() - timeAtStart)/1_000_000.0);
        }
    }

    static class AddToEndArraylist implements Callable{
        @Override
        public String call() throws Exception {
            double timeAtStart = System.nanoTime();
            arrayList.add(arrayList.size(), "123");
            return String.valueOf((System.nanoTime() - timeAtStart)/1_000_000.0);
        }
    }
}

