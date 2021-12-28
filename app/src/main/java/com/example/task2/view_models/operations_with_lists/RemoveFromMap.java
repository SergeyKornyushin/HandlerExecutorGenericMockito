package com.example.task2.view_models.operations_with_lists;

import static com.example.task2.view_models.VariableStorage.*;

import com.example.task2.view_models.main_operations.Operation;

import java.util.HashMap;
import java.util.Map;

public class RemoveFromMap extends Operation {

    public RemoveFromMap(Map map) {
        super(map);
        setMap(map);
    }

    @Override
    public void calculate(Object collection) {
        if (map instanceof HashMap) {
            key = REMOVE_FROM_HASHMAP;
        } else {
            key = REMOVE_FROM_TREEMAP;
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
        map.remove(123);
    }
}
