package com.example.task2.interfaces;

import com.example.task2.VariableStorage.*;

import java.util.HashMap;

public interface NonUIToActivityInterface {
    void passDataFromNonUIToUIFragment(DefOperandTags fragmentTag, DefOperationTags operationTag, String result);
    void passResultsMapToUI(DefOperandTags fragmentTag, HashMap<DefOperationTags, String> resultsMap);
}