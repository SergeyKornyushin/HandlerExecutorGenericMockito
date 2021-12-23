package com.example.task2.view_models.main_operations;

import java.util.List;

public class CreateLists<T extends List> extends Operation implements Runnable {

    public CreateLists(List list) {
        super(list);
    }

    public CreateLists() {
    }

    @Override
    public void operation(Object collection) {
    }

    public void createList(T collection, int size) {
        if (collection.size() < size - 100 || collection.size() < (size / 100) - 10) {
            collection.clear();
            for (int i = 0; i < size; i++) {
                collection.add(i + "");
            }
        }
    }
}