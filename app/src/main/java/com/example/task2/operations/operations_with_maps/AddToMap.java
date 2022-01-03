package com.example.task2.operations.operations_with_maps;

import static com.example.task2.VariableStorage.*;

import com.example.task2.operations.main_operations.Operation;

import java.util.HashMap;
import java.util.Map;

public class AddToMap extends Operation {

    public AddToMap(Map map) {
        super(map);
        setMap(map);
    }

    @Override
    public void calculate(Object collection) {
        if (map instanceof HashMap) {
            key = ADDING_TO_HASHMAP;
        } else {
            key = ADDING_TO_TREEMAP;
        }
        super.calculate(map);
    }

    @Override
    public void run() {
        super.run();
    }

    @Override
    public void operation(Object collection) {
        Map map = (Map) collection;
        map.put(map.size(), "123");
    }
}