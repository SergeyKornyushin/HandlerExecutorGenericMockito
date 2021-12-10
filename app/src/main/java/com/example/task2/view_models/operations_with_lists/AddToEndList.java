package com.example.task2.view_models.operations_with_lists;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.example.task2.view_models.main_operations.CreateLists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AddToEndList extends CreateLists {

    public AddToEndList(List list, Handler handler) {
        super(list, handler);
        setHandler(handler);
        setList(list);
    }

    @Override
    public void operation(Object collection) {
        List list = (List) collection;
        list.add(list.size(), "123");
    }

    @Override
    public void run() {
        Message msg;

        if (list instanceof ArrayList){
            String result = "Adding to end of ArrayList: \n"
                    + calculate(list) + " ms";
            msg = handler.obtainMessage(3, result);
            handler.sendMessage(msg);
        } else if (list instanceof LinkedList){
            String result = "Adding to end of LinkedList: \n"
                    + calculate(list) + " ms";
            msg = handler.obtainMessage(13, result);
            handler.sendMessage(msg);
        } else {
            String result = "Adding to end of CopyOnWriteArrayList: \n"
                    + calculate(list) + " ms";
            msg = handler.obtainMessage(23, result);
            handler.sendMessage(msg);
        }
    }
}