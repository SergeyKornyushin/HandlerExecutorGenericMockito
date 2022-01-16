package com.example.task2.operations.main_operations;

import static com.example.task2.VariableStorage.DefOperationTags.OPERAND_IS_FILLING;

import android.os.Handler;
import android.os.Message;

import java.util.List;

public class FillingGeneral implements Runnable{
    public Handler handler;
    public int size;
    public List<Operation> listOfOperations;

    @Override
    public void run() {
        Message msg = handler.obtainMessage(OPERAND_IS_FILLING.ordinal(), listOfOperations);
        handler.sendMessage(msg);
    }
}