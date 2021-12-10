package com.example.task2.view_models.main_operations;

import android.os.Handler;

import java.util.List;
import java.util.Map;

public abstract class Operation<T> implements Runnable {

    public Operation(List list, Handler handler) {
    }

    public Operation(Map map, Handler handler) {
    }

    public Operation() {
    }

    public Handler handler;
    public List list;

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public void setList(List list){
        this.list = list;
    }

    public String calculate(T collection) {

        double timeStart = System.nanoTime();

        operation(collection);

        double timeEnd = System.nanoTime();


        return ((timeEnd - timeStart) / 1_000_000.0) + "";
    }

    public abstract void operation(T collection);
}
