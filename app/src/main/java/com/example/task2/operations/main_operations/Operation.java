package com.example.task2.operations.main_operations;

import static com.example.task2.VariableStorage.DefOperandTags.*;
import static com.example.task2.VariableStorage.NON_USABLE_ARGUMENT;

import android.os.Handler;
import android.os.Message;

import androidx.test.espresso.idling.CountingIdlingResource;

import com.example.task2.VariableStorage.*;

public abstract class Operation<T> implements Runnable {

    public Operation(T listOrMap) {
        operand = listOrMap;
    }

    public T operand;
    public Handler handler;
    public Message msg;
    public DefOperationTags key;
    public DefOperandTags tagOfOperand = COLLECTIONS_TAG;

    @Override
    public void run() {
        calculate(operand);
    }

    public void calculate(T operand) {

        long timeStart = System.currentTimeMillis();

        operation(operand);

        long timeEnd = System.currentTimeMillis() - timeStart;

        msg = handler.obtainMessage(key.ordinal(), tagOfOperand.ordinal(),
                NON_USABLE_ARGUMENT, timeEnd);
        handler.sendMessage(msg);
    }

    public abstract void operation(T operand);
}