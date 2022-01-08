package com.example.task2.operations.operations_with_maps;

import static com.example.task2.VariableStorage.*;

import com.example.task2.operations.main_operations.Operation;

import java.util.HashMap;
import java.util.Map;

public class RemoveFromMap extends Operation {

    public RemoveFromMap(Map map) {
        super(map);
    }

    @Override
    public void calculate(Object map) {
        if (map instanceof HashMap) {
            key = REMOVE_FROM_HASHMAP;
        } else {
            key = REMOVE_FROM_TREEMAP;
        }
        tagOfOperand = MAPS_TAG;
        super.calculate(map);
    }

    @Override
    public void operation(Object map) {
        ((Map)map).remove(123);
    }
}