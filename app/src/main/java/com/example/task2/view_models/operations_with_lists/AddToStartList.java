package com.example.task2.view_models.operations_with_lists;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.task2.view_models.main_operations.CreateLists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AddToStartList extends CreateLists {

    public AddToStartList(List list, Handler handler) {
        super(list, handler);
        setHandler(handler);
        setList(list);
    }

    @Override
    public void run() {
        Message msg;

        if (list instanceof ArrayList){
            String result = "Adding to start of ArrayList: \n"
                    + calculate(list) + " ms";
            msg = handler.obtainMessage(1, result);
            handler.sendMessage(msg);
        } else if (list instanceof LinkedList){
            String result = "Adding to start of LinkedList: \n"
                    + calculate(list) + " ms";
            msg = handler.obtainMessage(11, result);
            handler.sendMessage(msg);
        } else {
            String result = "Adding to start of CopyOnWriteArrayList: \n"
                    + calculate(list) + " ms";
            msg = handler.obtainMessage(21, result);
            handler.sendMessage(msg);
        }


    }

    @Override
    public void operation(Object collection) {
        List list = (List) collection;
        list.add(0, "123");
    }


}
