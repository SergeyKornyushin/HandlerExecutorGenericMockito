package com.example.task2.view_models.operations_with_arraylist;

import static com.example.task2.view_models.ListsFragmentViewModel.arrayList;
import static com.example.task2.view_models.ListsFragmentViewModel.collectionSize;

import android.util.Log;

import com.example.task2.view_models.LiveDataVariablesViewModel;
import com.example.task2.view_models.main_operations.CollectionOperation;

import java.util.List;

public class SearchInListSubmit implements Runnable {

    @Override
    public void run() {
        SearchInList searchInList = new SearchInList();
        LiveDataVariablesViewModel.searchInListResult.postValue("Search in ArrayList: \n"
                + searchInList.calculate(arrayList) + " ms");
    }

    private static class SearchInList extends CollectionOperation {
        boolean cont;
        @Override
        public void operation(List collection) {
            cont = collection.contains("123");
//            Log.i("test4", "7. SearchInArrayList: " + Thread.currentThread().getName());
        }
    }
}