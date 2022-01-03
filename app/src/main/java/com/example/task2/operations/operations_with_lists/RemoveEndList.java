package com.example.task2.operations.operations_with_lists;

import static com.example.task2.VariableStorage.*;

import com.example.task2.operations.main_operations.Operation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RemoveEndList extends Operation {

    public RemoveEndList(List list) {
        super(list);
        setList(list);
    }

    @Override
    public void run() {
        super.run();
    }

    @Override
    public void calculate(Object collection) {
        if (list instanceof ArrayList) {
            key = REMOVE_END_ARRAYLIST;
        } else if (list instanceof LinkedList) {
            key = REMOVE_END_LINKEDLIST;
        } else {
            key = REMOVE_END_COW_ARRAYLIST;
        }
        super.calculate(list);
    }

    @Override
    public void operation(Object collection) {
        List list = (List) collection;
        list.remove(list.size()-3);
    }
}