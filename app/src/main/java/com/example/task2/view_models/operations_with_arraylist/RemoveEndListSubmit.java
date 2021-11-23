package com.example.task2.view_models.operations_with_arraylist;

import static com.example.task2.view_models.ListsFragmentViewModel.arrayList;
import static com.example.task2.view_models.ListsFragmentViewModel.collectionSize;

import android.util.Log;

import com.example.task2.view_models.LiveDataVariablesViewModel;
import com.example.task2.view_models.main_operations.CollectionOperation;

import java.util.List;

public class RemoveEndListSubmit implements Runnable {

    @Override
    public void run() {
        RemoveEndList removeEndList = new RemoveEndList();
        LiveDataVariablesViewModel.removeEndListResult.postValue("Removing from end of ArrayList: \n"
                + removeEndList.calculate(arrayList) + " ms");
    }

    private static class RemoveEndList extends CollectionOperation {

        @Override
        public void operation(List collection) {
            collection.remove(collection.size()-1);
//            Log.i("test4", "6. RemoveEndArrayList: " + Thread.currentThread().getName());
        }
    }
}
