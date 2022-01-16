package com.example.task2.interfaces;

import com.example.task2.VariableStorage.*;

import java.util.HashMap;

public interface FragmentsGeneralMethodsInterface {
    void setProgressBarVisibility();
    void postSingleOperationResult(DefOperationTags operationTag, String result);
    void postBatchOperationResults(HashMap<DefOperationTags, String> resultsMap);
}
