package com.example.task2.operations.main_operations;

import static com.example.task2.VariableStorage.DefOperationTags.*;

import com.example.task2.operations.operations_with_lists.*;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class FillingCOWArrayList extends FillingGeneral {
    public FillingCOWArrayList(CopyOnWriteArrayList<String> cOWArrayList) {
        this.cOWArrayList = cOWArrayList;
    }

    private final CopyOnWriteArrayList<String> cOWArrayList;

    @Override
    public void run() {
        if (cOWArrayList.size() != size) {
            cOWArrayList.clear();
            for (int i = 0; i < size; i++) {
                cOWArrayList.add(i + "");
            }
        }
        listOfOperations = Arrays.asList(
                new AddToStartList(cOWArrayList, ADD_TO_START_COW_ARRAYLIST),
                new AddToMiddleList(cOWArrayList, ADD_TO_MIDDLE_COW_ARRAYLIST),
                new AddToEndList(cOWArrayList, ADD_TO_END_COW_ARRAYLIST),
                new SearchInList(cOWArrayList, SEARCH_IN_COW_ARRAYLIST),
                new RemoveStartList(cOWArrayList, REMOVE_BEGIN_COW_ARRAYLIST),
                new RemoveMiddleList(cOWArrayList, REMOVE_MIDDLE_COW_ARRAYLIST),
                new RemoveEndList(cOWArrayList, REMOVE_END_COW_ARRAYLIST)
        );
        super.run();
    }
}