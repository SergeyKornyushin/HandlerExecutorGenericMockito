package com.example.task2.view_models.main_operations;

import static com.example.task2.view_models.ListsFragmentViewModel.syn;

import java.util.List;

public abstract class Operation<T extends List> {

    public String calculate(T collection){

        synchronized (syn){
            try {
                syn.wait(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            double timeStart = System.nanoTime();

            operation(collection);

            return ((System.nanoTime() - timeStart) / 1_000_000.0)+"";
        }

    }

    public abstract void operation(T collection);
}
