package com.example.task2.view_models.operations_with_arraylist;

import static com.example.task2.view_models.ListsFragmentViewModel.collectionSize;
import static com.example.task2.view_models.ListsFragmentViewModel.arrayList;

import android.util.Log;

import com.example.task2.view_models.LiveDataVariablesViewModel;
import com.example.task2.view_models.main_operations.CollectionOperation;

import java.util.List;

public class AddToMiddleListSubmit implements Runnable {

    @Override
    public void run() {
        AddToMiddleList addToMiddleList = new AddToMiddleList();
        LiveDataVariablesViewModel.addToMiddleListResult.postValue("Adding to middle of ArrayList: \n"
                + addToMiddleList.calculate(arrayList) + " ms");
    }

    private static class AddToMiddleList extends CollectionOperation {

        @Override
        public void operation(List collection) {
            collection.add(collection.size() / 2, "123");
//            Log.i("test4", "2. AddToMiddleArrayList: " + Thread.currentThread().getName()+" hash "+arrayList.hashCode());
        }

    }
}
