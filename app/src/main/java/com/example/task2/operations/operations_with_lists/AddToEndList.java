package com.example.task2.operations.operations_with_lists;

import static com.example.task2.VariableStorage.*;

import com.example.task2.operations.main_operations.Operation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AddToEndList extends Operation {

    public AddToEndList(List list) {
        super(list);
    }

    @Override
    public void calculate(Object collection) {
        if (collection instanceof ArrayList) {
            key = ADD_TO_END_ARRAYLIST;
        } else if (collection instanceof LinkedList) {
            key = ADD_TO_END_LINKEDLIST;
        } else {
            key = ADD_TO_END_COW_ARRAYLIST;
        }
        tagOfOperand = COLLECTIONS_TAG;
        super.calculate(collection);
    }

    @Override
    public void operation(Object collection) {
        ((List)collection).add(((List)collection).size()-3, "123");
    }
}