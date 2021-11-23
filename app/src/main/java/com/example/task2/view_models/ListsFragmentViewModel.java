package com.example.task2.view_models;

import androidx.lifecycle.ViewModel;

import com.example.task2.view_models.main_operations.CreateLists;
import com.example.task2.view_models.operations_with_arraylist.*;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ListsFragmentViewModel extends ViewModel {

    public static ArrayList<String> arrayList = new ArrayList<>();
    public static LinkedList<String> linkedList = new LinkedList<>();
    public static CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
    public static double collectionSize;
    public static final Object syn = new Object();

    public void startThreads() throws ExecutionException, InterruptedException {
        collectionSize = 300000;
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.submit(new CreateCollections());
        executorService.submit(new AddToStartListSubmit());
        executorService.submit(new AddToMiddleListSubmit());
        executorService.submit(new AddToEndListSubmit());
        executorService.submit(new SearchInListSubmit());
        executorService.submit(new RemoveStartListSubmit());
        executorService.submit(new RemoveMiddleListSubmit());
        executorService.submit(new RemoveEndListSubmit());
        executorService.shutdown();
    }

}

