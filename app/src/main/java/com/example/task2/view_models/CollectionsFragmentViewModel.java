package com.example.task2.view_models;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CollectionsFragmentViewModel extends ViewModel {
    public static ArrayList<String> arrayList = new ArrayList<>();
    public MutableLiveData<String> addToStartArraylistResult = new MutableLiveData<>();
    public MutableLiveData<String> addToMiddleArraylistResult = new MutableLiveData<>();
    public MutableLiveData<String> addToEndArraylistResult = new MutableLiveData<>();
    public ExecutorService executorService;

    public void startThreads() throws ExecutionException, InterruptedException{
        Log.i("test4", "startThreads " + Thread.currentThread().getName());
        executorService = Executors.newFixedThreadPool(10);

        executorService.submit(new CreateLists());
        addToStartArraylistResult.setValue("Adding to start in ArrayList: \n"
                + executorService.submit(new AddToStartArraylist()).get() + " ms");
        addToMiddleArraylistResult.setValue("Adding to middle of ArrayList: \n"
                + executorService.submit(new AddToMiddleArraylist()).get() + " ms");
        addToEndArraylistResult.setValue("Adding to end of ArrayList: \n"
                + executorService.submit(new AddToEndArraylist()).get() + " ms");
        Log.i("test4", "shutdown");
        executorService.shutdown();
    }


    static class CreateLists implements Runnable {
        @Override
        public void run() {
            Log.i("test4", "CreateLists " + Thread.currentThread().getName());
            for (int i = 0; i < 5000000; i++) {
                arrayList.add(i + "");
            }
        }
    }

    static class AddToStartArraylist implements Callable {
        @Override
        public String call() throws Exception {
            double timeAtStart = System.nanoTime();
            Log.i("test4", "AddToStartArraylist " + Thread.currentThread().getName());
            arrayList.add(0, "123");
            return String.valueOf((System.nanoTime() - timeAtStart) / 1_000_000.0);
        }
    }

    static class AddToMiddleArraylist implements Callable {
        @Override
        public String call() throws Exception {
            double timeAtStart = System.nanoTime();
            arrayList.add(arrayList.size() / 2, "123");
            Log.i("test4", "AddToMiddleArraylist " + Thread.currentThread().getName());
            return String.valueOf((System.nanoTime() - timeAtStart) / 1_000_000.0);
        }
    }

    static class AddToEndArraylist implements Callable {
        @Override
        public String call() throws Exception {
            double timeAtStart = System.nanoTime();
            arrayList.add(arrayList.size(), "123");
            Log.i("test4", "AddToEndArraylist " + Thread.currentThread().getName());
            return String.valueOf((System.nanoTime() - timeAtStart) / 1_000_000.0);
        }
    }
}

