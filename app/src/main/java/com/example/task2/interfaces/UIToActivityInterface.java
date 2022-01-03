package com.example.task2.interfaces;

import com.example.task2.operations.main_operations.FillingCollectionsAndMaps;
import com.example.task2.operations.main_operations.Operation;

import java.util.List;

public interface UIToActivityInterface {
    void passListOperationsFromUI(List<Operation> list);
    void startCreateCollectionOrMap(String collectionOrMap, int collectionSize, int numberOfThreads,
                                    List<FillingCollectionsAndMaps> listCollectionsOrMaps);
    void requestResultsForUI(String collectionOrMap);
}