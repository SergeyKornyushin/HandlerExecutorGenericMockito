package com.example.task2.view_models.operations_with_arraylist;

import static com.example.task2.view_models.ListsFragmentViewModel.arrayList;
import static com.example.task2.view_models.ListsFragmentViewModel.collectionSize;

import android.util.Log;

import com.example.task2.view_models.LiveDataVariablesViewModel;
import com.example.task2.view_models.main_operations.CollectionOperation;

import java.util.List;

public class RemoveStartListSubmit implements Runnable {

    @Override
    public void run() {
        RemoveStartList removeStartList = new RemoveStartList();
        LiveDataVariablesViewModel.removeStartListResult.postValue("Removing from start of ArrayList: \n"
                + removeStartList.calculate(arrayList) + " ms");
    }

    private static class RemoveStartList extends CollectionOperation {

        @Override
        public void operation(List collection) {
            collection.remove(0);
//            Log.i("test4", "4. RemoveStartArrayList: " + Thread.currentThread().getName());
        }
    }
}