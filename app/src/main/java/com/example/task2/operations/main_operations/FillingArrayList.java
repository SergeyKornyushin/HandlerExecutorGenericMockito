package com.example.task2.operations.main_operations;

import static com.example.task2.VariableStorage.DefOperationTags.*;

import androidx.test.espresso.idling.CountingIdlingResource;

import com.example.task2.operations.operations_with_lists.*;
import com.example.task2.util.EspressoIdlingResource;

import java.util.ArrayList;
import java.util.Arrays;

public class FillingArrayList extends FillingGeneral {
    public FillingArrayList(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    private final ArrayList<String> arrayList;

    @Override
    public void run() {
        EspressoIdlingResource.increment();
        if (arrayList.size() != size) {
            arrayList.clear();
            for (int i = 0; i < size; i++) {
                arrayList.add(i + "");
            }
        }
        listOfOperations = Arrays.asList(
                new AddToStartList(arrayList, ADD_TO_START_ARRAYLIST),
                new AddToMiddleList(arrayList, ADD_TO_MIDDLE_ARRAYLIST),
                new AddToEndList(arrayList, ADD_TO_END_ARRAYLIST),
                new SearchInList(arrayList, SEARCH_IN_ARRAYLIST),
                new RemoveStartList(arrayList, REMOVE_BEGIN_ARRAYLIST),
                new RemoveMiddleList(arrayList, REMOVE_MIDDLE_ARRAYLIST),
                new RemoveEndList(arrayList, REMOVE_END_ARRAYLIST)
        );
        super.run();
        EspressoIdlingResource.decrement();
    }
}