package com.example.task2.view_models.operations_with_arraylist;

import static com.example.task2.view_models.ListsFragmentViewModel.arrayList;
import static com.example.task2.view_models.ListsFragmentViewModel.collectionSize;

import android.util.Log;

import com.example.task2.view_models.LiveDataVariablesViewModel;
import com.example.task2.view_models.main_operations.CollectionOperation;

import java.util.List;

public class AddToStartListSubmit implements Runnable {

    @Override
    public void run() {
        AddToStartList addToStartList = new AddToStartList();
        LiveDataVariablesViewModel.addToStartListResult.postValue("Adding to start of ArrayList: \n"
                + addToStartList.calculate(arrayList) + " ms");
    }

    private static class AddToStartList extends CollectionOperation {

        public void operation(List collection) {
            collection.add(0, "123");
//            Log.i("test4", "1. AddToStartArrayList: " + Thread.currentThread().getName()+" hash "+arrayList.hashCode());
        }

    }
}
