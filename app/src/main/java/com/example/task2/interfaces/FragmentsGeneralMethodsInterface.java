package com.example.task2.interfaces;

import java.util.HashMap;

public interface FragmentsGeneralMethodsInterface {
    void getCollectionOrMap(Object listOrMap);
    void setProgressBarVisibility();
    void postSingleOperationResult(int widgetTag, String value);
    void postBatchOperationResults(HashMap<Integer, String> resultsMap);
}
