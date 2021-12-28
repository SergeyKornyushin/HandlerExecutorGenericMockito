package com.example.task2.view_models.main_operations;

import static com.example.task2.view_models.VariableStorage.*;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FillingCollectionsAndMaps<T> extends Operation implements Runnable {
    public int size;
    private T collectionOrMap;

    public FillingCollectionsAndMaps(T collectionOrMap) {
        this.collectionOrMap = collectionOrMap;
    }

    public void fillingCollectionOrMap(T collectionOrMap) {

        if (collectionOrMap instanceof List) {
            setList((List) collectionOrMap);
            if (list.size() != size){
                list.clear();
                for (int i = 0; i < size; i++) {
                    list.add(i + "");
                }
            }
            if (list instanceof ArrayList) {
                msg = handler.obtainMessage(ARRAYLIST_IS_READY);
            } else if (list instanceof LinkedList) {
                msg = handler.obtainMessage(LINKEDLIST_IS_READY);
            } else {
                msg = handler.obtainMessage(COW_ARRAYLIST_IS_READY);
            }
        } else {
            setMap((Map) collectionOrMap);
            if (map.size() != size){
                Log.i("test4", "size !=: "+map.size());
                map.clear();
                for (int i = 0; i < size; i++) {
                    ((Map<Integer, String>) collectionOrMap).put(i, i + "");
                }
            }
            if (map instanceof HashMap) {
                msg = handler.obtainMessage(HASHMAP_IS_READY);
            } else {
                msg = handler.obtainMessage(TREEMAP_IS_READY);
            }
        }
        handler.sendMessage(msg);
    }

    @Override
    public void run() {
        fillingCollectionOrMap(collectionOrMap);
    }

    @Override
    public void operation(Object collection) {
    }
}
