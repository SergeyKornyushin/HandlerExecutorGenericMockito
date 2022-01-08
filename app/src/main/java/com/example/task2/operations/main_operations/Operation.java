package com.example.task2.operations.main_operations;

import android.os.Handler;
import android.os.Message;

public abstract class Operation<T> implements Runnable {

    public Operation(T listOrMap) {
        operand = listOrMap;
    }

    public T operand;
    public Handler handler;
    public Message msg;
    public int key;
    public int tagOfOperand;

    @Override
    public void run() {
        calculate(operand);
    }

    public void calculate(T operand) {

        long timeStart = System.currentTimeMillis();

        operation(operand);

        long timeEnd = System.currentTimeMillis() - timeStart;

        msg = handler.obtainMessage(key, tagOfOperand, 99 , timeEnd);
        handler.sendMessage(msg);
    }

    public abstract void operation(T operand);
}