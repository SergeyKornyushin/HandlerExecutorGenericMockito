package com.example.task2.view_models.operations_with_arraylist;

import static com.example.task2.view_models.ListsFragmentViewModel.arrayList;
import static com.example.task2.view_models.ListsFragmentViewModel.collectionSize;

import android.util.Log;

import com.example.task2.view_models.LiveDataVariablesViewModel;
import com.example.task2.view_models.main_operations.CollectionOperation;
import com.example.task2.view_models.main_operations.CreateLists;

import java.util.List;

public class AddToEndListSubmit implements Runnable {

    @Override
    public void run() {
        AddToEndList addToEndList = new AddToEndList();
        LiveDataVariablesViewModel.addToEndListResult.postValue("Adding to end of ArrayList: \n"
                + addToEndList.calculate(arrayList) + " ms");
    }

    private static class AddToEndList extends CollectionOperation {

        @Override
        public void operation(List collection) {
            collection.add(collection.size(), "123");
//            Log.i("test4", "3. AddToEndArraylist: " + Thread.currentThread().getName()+" hash "+arrayList.hashCode());
        }

    }
}