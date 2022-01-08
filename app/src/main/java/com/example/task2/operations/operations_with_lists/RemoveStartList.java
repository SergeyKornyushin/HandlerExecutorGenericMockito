package com.example.task2.operations.operations_with_lists;

import static com.example.task2.VariableStorage.*;

import com.example.task2.operations.main_operations.Operation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RemoveStartList extends Operation {

    public RemoveStartList(List list) {
        super(list);
    }

    @Override
    public void calculate(Object collection) {
        if (collection instanceof ArrayList) {
            key = REMOVE_BEGIN_ARRAYLIST;
        } else if (collection instanceof LinkedList) {
            key = REMOVE_BEGIN_LINKEDLIST;
        } else {
            key = REMOVE_BEGIN_COW_ARRAYLIST;
        }
        tagOfOperand = COLLECTIONS_TAG;
        super.calculate(collection);
    }

    @Override
    public void operation(Object collection) {
        ((List)collection).remove(0);
    }
}