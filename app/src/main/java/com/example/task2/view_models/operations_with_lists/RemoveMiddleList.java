package com.example.task2.view_models.operations_with_lists;

import static com.example.task2.view_models.VariableStorage.*;

import com.example.task2.view_models.main_operations.CreateLists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RemoveMiddleList extends CreateLists {

    public RemoveMiddleList(List list) {
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
            key = REMOVE_MIDDLE_ARRAYLIST;
        } else if (list instanceof LinkedList) {
            key = REMOVE_MIDDLE_LINKEDLIST;
        } else {
            key = REMOVE_MIDDLE_COW_ARRAYLIST;
        }
        super.calculate(list);
    }

    @Override
    public void operation(Object collection) {
        List list = (List) collection;
        list.remove(list.size() / 2);
    }
}