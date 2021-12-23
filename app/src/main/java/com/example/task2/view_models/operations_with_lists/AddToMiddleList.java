package com.example.task2.view_models.operations_with_lists;

import static com.example.task2.view_models.VariableStorage.*;

import android.os.Handler;
import android.os.Message;

import com.example.task2.view_models.main_operations.CreateLists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AddToMiddleList extends CreateLists {

    public AddToMiddleList(List list) {
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
            key = ADD_TO_MIDDLE_ARRAYLIST;
        } else if (list instanceof LinkedList) {
            key = ADD_TO_MIDDLE_LINKEDLIST;
        } else {
            key = ADD_TO_MIDDLE_COW_ARRAYLIST;
        }
        super.calculate(list);
    }

    @Override
    public void operation(Object collection) {
        List list = (List) collection;
        list.add(list.size() / 2, "123");
    }
}
