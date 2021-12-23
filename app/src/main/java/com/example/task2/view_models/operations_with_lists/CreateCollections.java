package com.example.task2.view_models.operations_with_lists;

import static com.example.task2.fragments.NonUIFragment.*;

import com.example.task2.view_models.main_operations.CreateLists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

public class CreateCollections implements Runnable {

    private int collectionSize;

    public CreateCollections(int collectionSize) {
        this.collectionSize = collectionSize;
    }

    @Override
    public void run() {
        CreateLists createLists = new CreateLists();
        createLists.createList(arrayList, collectionSize);
        createLists.createList(linkedList, collectionSize);
        createLists.createList(copyOnWriteArrayList, collectionSize / 100);
    }
}
