package com.example.task2.view_models.main_operations;

import java.util.List;

public class CreateLists<T extends List> {

    public void createList(T collection, double size){

        if (collection.size() != size || collection.size() != size / 100){
            collection.clear();
            for (double i = 0; i < size; i++){
                collection.add(i+"");
            }
        }
    }
}
