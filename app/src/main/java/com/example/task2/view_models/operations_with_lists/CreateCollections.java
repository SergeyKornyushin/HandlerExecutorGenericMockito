package com.example.task2.view_models.operations_with_lists;

import android.util.Log;

import com.example.task2.view_models.main_operations.CreateLists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

public class CreateCollections implements Runnable {

    private final Double collectionSize;
    private ArrayList arrayList;
    private LinkedList linkedList;
    private CopyOnWriteArrayList copyOnWriteArrayList;

    public CreateCollections(Double collectionSize,
                             ArrayList arrayList,
                             LinkedList linkedList,
                             CopyOnWriteArrayList copyOnWriteArrayList) {
        this.collectionSize = collectionSize;
        this.arrayList = arrayList;
        this.linkedList = linkedList;
        this.copyOnWriteArrayList = copyOnWriteArrayList;
    }

    @Override
    public void run() {
        CreateLists createLists = new CreateLists();
        createLists.createList(arrayList, collectionSize);
        createLists.createList(linkedList, collectionSize);
        createLists.createList(copyOnWriteArrayList, collectionSize / 1000);
    }
}
