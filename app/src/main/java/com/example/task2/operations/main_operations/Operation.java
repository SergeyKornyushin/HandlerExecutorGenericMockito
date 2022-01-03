package com.example.task2.operations.main_operations;

import android.os.Handler;
import android.os.Message;

import java.util.List;
import java.util.Map;

public abstract class Operation<T> implements Runnable {

    public Operation(T listOrMap) {
    }

    public Operation() {
    }

    public T collection;
    public Handler handler;
    public List list;
    public Map map;
    public Message msg;
    public int key;

    @Override
    public void run() {
        calculate(collection);
    }

    public void setList(List list) {
        this.list = list;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void calculate(T collection) {

        long timeStart = System.currentTimeMillis();

        operation(collection);

        long timeEnd = System.currentTimeMillis() - timeStart;

        msg = handler.obtainMessage(key, timeEnd);
        handler.sendMessage(msg);
    }

    public abstract void operation(T collection);
}