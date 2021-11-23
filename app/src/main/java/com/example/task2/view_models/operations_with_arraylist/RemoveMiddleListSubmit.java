package com.example.task2.view_models.operations_with_arraylist;

import static com.example.task2.view_models.ListsFragmentViewModel.arrayList;
import static com.example.task2.view_models.ListsFragmentViewModel.collectionSize;

import android.util.Log;

import com.example.task2.view_models.LiveDataVariablesViewModel;
import com.example.task2.view_models.main_operations.CollectionOperation;

import java.util.List;

public class RemoveMiddleListSubmit implements Runnable {

    @Override
    public void run() {
        RemoveMiddleList removeMiddleList = new RemoveMiddleList();
        LiveDataVariablesViewModel.removeMiddleListResult.postValue("Removing from middle of ArrayList: \n"
                + removeMiddleList.calculate(arrayList) + " ms");
    }

    private static class RemoveMiddleList extends CollectionOperation {

        @Override
        public void operation(List collection) {
            collection.remove(collection.size() / 2);
//            Log.i("test4", "5. RemoveMiddleList: " + Thread.currentThread().getName());
        }
    }
}