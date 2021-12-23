package com.example.task2.view_models.main_operations;

import java.util.Map;

public class CreateMaps<T extends Map> extends Operation implements Runnable {

    public CreateMaps(Map map) {
        super(map);
    }

    public CreateMaps() {
    }

    @Override
    public void operation(Object collection) {
    }

    public void createMap(T map, int size) {
        if (map.size() < size - 100) {
            map.clear();
            for (int i = 0; i < size; i++) {
                map.put(i, "" + i);
            }
        }
    }
}