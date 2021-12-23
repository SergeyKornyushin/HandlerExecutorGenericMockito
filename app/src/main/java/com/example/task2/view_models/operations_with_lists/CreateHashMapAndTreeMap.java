package com.example.task2.view_models.operations_with_lists;

import static com.example.task2.fragments.NonUIFragment.hashMap;
import static com.example.task2.fragments.NonUIFragment.treeMap;

import com.example.task2.view_models.main_operations.CreateMaps;

public class CreateHashMapAndTreeMap implements Runnable {

    private int collectionSize;

    public CreateHashMapAndTreeMap(int collectionSize) {
        this.collectionSize = collectionSize;
    }

    @Override
    public void run() {
        CreateMaps createMaps = new CreateMaps();
        createMaps.createMap(hashMap, collectionSize);
        createMaps.createMap(treeMap, collectionSize);
    }
}
