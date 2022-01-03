package com.example.task2.operations.main_operations;

import static com.example.task2.VariableStorage.*;

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
            msg = handler.obtainMessage(LIST_OR_MAP_IS_READY, list);
        } else {
            setMap((Map) collectionOrMap);
            if (map.size() != size){
                map.clear();
                for (int i = 0; i < size; i++) {
                    map.put(i, i + "");
                }
            }
            msg = handler.obtainMessage(LIST_OR_MAP_IS_READY, map);
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