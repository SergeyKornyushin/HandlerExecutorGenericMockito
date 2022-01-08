package com.example.task2.operations.operations_with_maps;

import static com.example.task2.VariableStorage.*;

import com.example.task2.operations.main_operations.Operation;

import java.util.HashMap;
import java.util.Map;

public class AddToMap extends Operation {

    public AddToMap(Map map) {
        super(map);
    }

    @Override
    public void calculate(Object map) {
        if (map instanceof HashMap) {
            key = ADDING_TO_HASHMAP;
        } else {
            key = ADDING_TO_TREEMAP;
        }
        tagOfOperand = MAPS_TAG;
        super.calculate(map);
    }

    @Override
    public void operation(Object map) {
        ((Map) map).put(((Map) map).size(), "123");
    }
}