package com.example.task2.view_models.operations_with_lists;

import static com.example.task2.view_models.VariableStorage.*;

import com.example.task2.view_models.main_operations.CreateLists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SearchInList extends CreateLists {

    public SearchInList(List list) {
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
            key = SEARCH_IN_ARRAYLIST;
        } else if (list instanceof LinkedList) {
            key = SEARCH_IN_LINKEDLIST;
        } else {
            key = SEARCH_IN_COW_ARRAYLIST;
        }
        super.calculate(list);
    }

    @Override
    public void operation(Object collection) {
        List list = (List) collection;
        list.contains("123");
    }
}