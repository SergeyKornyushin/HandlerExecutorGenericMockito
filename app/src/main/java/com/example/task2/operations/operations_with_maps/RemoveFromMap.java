package com.example.task2.operations.operations_with_maps;

import static com.example.task2.VariableStorage.DefOperandTags.MAPS_TAG;

import com.example.task2.VariableStorage.*;
import com.example.task2.operations.main_operations.Operation;

import java.util.Map;

public class RemoveFromMap extends Operation {

    public RemoveFromMap(Map map, DefOperationTags operationTag) {
        super(map);
        key = operationTag;
        tagOfOperand = MAPS_TAG;
    }


    @Override
    public void operation(Object map) {
        ((Map)map).remove(123);
    }
}