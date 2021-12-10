package com.example.task2.view_models.main_operations;

import android.os.Handler;

import java.util.Map;

public class CreateMaps<T extends Map> extends Operation implements Runnable {

    public CreateMaps(Map map, Handler handler) {
        super(map, handler);
    }

    public CreateMaps() {
    }

    @Override
    public void operation(Object collection) {
    }


    public void createMap(T map, double size) {
        if (map.size() < size - 100) {

            map.clear();
            for (double i = 0; i < size; i++) {
                map.put(i, "" + i);
            }

        }
    }

    @Override
    public void run() {
    }
}