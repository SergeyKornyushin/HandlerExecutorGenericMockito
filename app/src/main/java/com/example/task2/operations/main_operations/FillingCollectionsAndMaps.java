package com.example.task2.operations.main_operations;

import static com.example.task2.VariableStorage.*;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.util.List;
import java.util.Map;

public class FillingCollectionsAndMaps<T> implements Runnable {
    private final T collectionOrMap;
    public int size;
    public Handler handler;

    public FillingCollectionsAndMaps(T collectionOrMap) {
        this.collectionOrMap = collectionOrMap;
    }

    @Override
    public void run() {
        if (collectionOrMap instanceof List) {
            if (((List)collectionOrMap).size() != size){
                ((List)collectionOrMap).clear();
                for (int i = 0; i < size; i++) {
                    ((List)collectionOrMap).add(i + "");
                }
            }
        } else {
            if (((Map)collectionOrMap).size() != size){
                ((Map)collectionOrMap).clear();
                for (int i = 0; i < size; i++) {
                    ((Map)collectionOrMap).put(i, i + "");
                }
            }
        }
        Message msg = handler.obtainMessage(LIST_OR_MAP_IS_READY, collectionOrMap);
        handler.sendMessage(msg);
    }
}