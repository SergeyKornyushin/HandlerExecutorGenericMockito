package com.example.task2.view_models.main_operations;

import android.os.Handler;
import android.util.Log;

import java.util.List;
import java.util.concurrent.Semaphore;


public class CreateLists<T extends List> extends Operation implements Runnable {


    public CreateLists(List list, Handler handler) {
        super(list, handler);
    }

    public CreateLists() {}

    @Override
    public void operation(Object collection) {}


    public void createList(T collection, double size){
        if (collection.size() < size-100 || collection.size() < (size / 100)-10){

            collection.clear();
            for (double i = 0; i < size; i++){
                collection.add(i+"");
            }

        }
    }

    @Override
    public void run() {}
}
