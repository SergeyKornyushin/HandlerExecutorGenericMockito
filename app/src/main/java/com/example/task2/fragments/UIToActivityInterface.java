package com.example.task2.fragments;

import com.example.task2.view_models.main_operations.Operation;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface UIToActivityInterface {
    void passListOperationsFromUI(List<Operation> list)
            throws ExecutionException, InterruptedException;
    void startCreateCollectionOrMap(String collectionOrMap, int collectionSize, int numberOfThreads)
            throws ExecutionException, InterruptedException;
    void requestResultsForUI(String collectionOrMap);
}
