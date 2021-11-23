package com.example.task2.view_models.main_operations;

import java.util.ArrayList;
import java.util.List;

public  class CollectionOperation extends Operation implements Runnable{

    public void preprocessing(List collection, double size) {
        ArrayList<String > arrayList = new ArrayList<>();

        if (collection.size() != size){
            collection.clear();
            for (int i = 0; i < size; i++){
                collection.add(i+"");
            }
        }
    }

    @Override
    public void operation(List collection) {}


    @Override
    public void run() {

    }
}
