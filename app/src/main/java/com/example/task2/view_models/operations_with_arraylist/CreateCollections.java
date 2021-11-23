package com.example.task2.view_models.operations_with_arraylist;

import static com.example.task2.view_models.ListsFragmentViewModel.*;

import android.util.Log;

import com.example.task2.view_models.main_operations.CreateLists;

public class CreateCollections implements Runnable {

    @Override
    public void run() {
        synchronized (syn){
//            Log.i("test4", arrayList.size()+" "+linkedList.size()+" "+copyOnWriteArrayList.size()+" "+Thread.currentThread().getName());
            CreateLists createLists = new CreateLists();
            createLists.createList(arrayList, collectionSize);
//            Log.i("test4", arrayList.size()+" array");
            createLists.createList(linkedList, collectionSize);
//            Log.i("test4", linkedList.size()+" linked");
            createLists.createList(copyOnWriteArrayList, collectionSize/100);
//            Log.i("test4", copyOnWriteArrayList.size()+" cow");
            syn.notifyAll();
        }
    }
}
