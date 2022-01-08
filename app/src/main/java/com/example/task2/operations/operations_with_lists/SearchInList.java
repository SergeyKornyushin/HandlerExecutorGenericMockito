package com.example.task2.operations.operations_with_lists;

import static com.example.task2.VariableStorage.*;

import com.example.task2.operations.main_operations.Operation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SearchInList extends Operation {

    public SearchInList(List list) {
        super(list);
    }

    @Override
    public void calculate(Object collection) {
        if (collection instanceof ArrayList) {
            key = SEARCH_IN_ARRAYLIST;
        } else if (collection instanceof LinkedList) {
            key = SEARCH_IN_LINKEDLIST;
        } else {
            key = SEARCH_IN_COW_ARRAYLIST;
        }
        tagOfOperand = COLLECTIONS_TAG;
        super.calculate(collection);
    }

    @Override
    public void operation(Object collection) {
        ((List)collection).contains("123");
    }
}