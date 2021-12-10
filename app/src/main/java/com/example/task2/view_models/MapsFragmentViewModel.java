package com.example.task2.view_models;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MapsFragmentViewModel extends ViewModel {
    public static ArrayList<String> arrayList = new ArrayList<>();
    public static double operations;

    public void startThreads() throws ExecutionException, InterruptedException {
        operations = 10000;

        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        addToStartArraylistResult.postValue((executorService.submit(new AddToStartListSubmit())).get());
//        addToMiddleArrayListResult.postValue((executorService.submit(new AddToMiddleListSubmit())).get());
        executorService.shutdown();
    }
}
