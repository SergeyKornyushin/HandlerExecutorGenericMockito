/*
package com.example.task2.view_models;

import android.util.Log;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CollectionsFragmentViewModel extends ViewModel {
    public MutableLiveData<List<CollectionsFragmentViewModel>> listMutableLiveData = new MutableLiveData<>();
    public static ArrayList<String> arrayList = new ArrayList<>();
    public static MutableLiveData<String> addToStartArraylistResult = new MutableLiveData<>();
    public static MutableLiveData<String> addToMiddleArraylistResult = new MutableLiveData<>();
    public static MutableLiveData<String> addToEndArraylistResult = new MutableLiveData<>();
    public static MutableLiveData<String> searchInArraylistResult = new MutableLiveData<>();
    public static MutableLiveData<String> removeStartArraylistResult = new MutableLiveData<>();
    public static MutableLiveData<String> removeMiddleArraylistResult = new MutableLiveData<>();
    public static MutableLiveData<String> removeEndArraylistResult = new MutableLiveData<>();
    public static MutableLiveData<Boolean> creationArray = new MutableLiveData<>();

    public void startThreads() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.submit(new CreateLists());
//        addToStartArraylistResult.setValue("0");
//        addToMiddleArraylistResult.setValue("0");
//        addToEndArraylistResult.setValue("0");
//        searchInArraylistResult.setValue("0");
//        removeStartArraylistResult.setValue("0");
//        removeMiddleArraylistResult.setValue("0");
//        removeEndArraylistResult.setValue("0");
        executorService.submit(new AddToStartArraylist());
        executorService.submit(new AddToMiddleArraylist());
        executorService.submit(new AddToEndArraylist());
        executorService.submit(new SearchInArraylist());
        executorService.submit(new RemoveStartArraylist());
        executorService.submit(new RemoveMiddleArraylist());
        executorService.submit(new RemoveEndArraylist());
        executorService.shutdown();
    }


    static class CreateLists implements Callable {
        @Override
        public String call() {
            if (arrayList.size() < 999000) {
                for (int i = 0; i < 1000001; i++) {
                    arrayList.add(i + "");
                }
            }
            creationArray.postValue(true);
            return "ready";
        }
    }

    static class AddToStartArraylist implements Runnable {
        @Override
        public void run() {
            if (arrayList.size() < 900000) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            double timeAtStart = System.nanoTime();
            arrayList.add(0, "123");

            addToStartArraylistResult.postValue("Adding to start in ArrayList: \n"
                    + ((System.nanoTime() - timeAtStart) / 1_000_000.0) + " ms");
        }
    }

    static class AddToMiddleArraylist implements Runnable {
        @Override
        public void run() {
            if (arrayList.size() < 900000) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            double timeAtStart = System.nanoTime();
            arrayList.add(arrayList.size() / 2, "123");
            addToMiddleArraylistResult.postValue("Adding to middle of ArrayList: \n"
                    + ((System.nanoTime() - timeAtStart) / 1_000_000.0) + " ms");
        }
    }

    static class AddToEndArraylist implements Runnable {
        @Override
        public void run() {
            if (arrayList.size() < 900000) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            double timeAtStart = System.nanoTime();
            arrayList.add(arrayList.size(), "123");
            addToEndArraylistResult.postValue("Adding to start of ArrayList: \n"
                    + ((System.nanoTime() - timeAtStart) / 1_000_000.0) + " ms");
        }
    }

    static class SearchInArraylist implements Runnable {
        @Override
        public void run() {
            if (arrayList.size() < 900000) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            double timeAtStart = System.nanoTime();
            if (arrayList.contains("98765")) {
                Boolean contain = true;
            }
            searchInArraylistResult.postValue("Search in ArrayList: \n"
                    + ((System.nanoTime() - timeAtStart) / 1_000_000.0) + " ms");
        }
    }

    static class RemoveStartArraylist implements Runnable {
        @Override
        public void run() {
            if (arrayList.size() < 900000) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            double timeAtStart = System.nanoTime();
            arrayList.remove(0);
            removeStartArraylistResult.postValue("Removing from start of ArrayList: \n"
                    + ((System.nanoTime() - timeAtStart) / 1_000_000.0) + " ms");
        }
    }

    static class RemoveMiddleArraylist implements Runnable {
        @Override
        public void run() {
            if (arrayList.size() < 900000) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            double timeAtStart = System.nanoTime();
            arrayList.remove(arrayList.size() / 2);
            removeMiddleArraylistResult.postValue("Removing from middle of ArrayList: \n"
                    + ((System.nanoTime() - timeAtStart) / 1_000_000.0) + " ms");
        }
    }

    static class RemoveEndArraylist implements Runnable {
        @Override
        public void run() {
            if (arrayList.size() < 900000) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            double timeAtStart = System.nanoTime();
            arrayList.remove(arrayList.size() - 1);
            removeEndArraylistResult.postValue("Removing from end of ArrayList: \n"
                    + ((System.nanoTime() - timeAtStart) / 1_000_000.0) + " ms");
        }

    }

}

*/
