package com.example.task2.interfaces;

import com.example.task2.VariableStorage.*;
import com.example.task2.operations.main_operations.FillingGeneral;

import java.util.List;

public interface UIToActivityInterface {
    void startCreateCollectionOrMap(DefOperandTags operandTag, int operandSize, int numberOfThreads,
                                    List<FillingGeneral> listCollectionsOrMaps);
    void requestResultsForUI(DefOperandTags operandTag);
}