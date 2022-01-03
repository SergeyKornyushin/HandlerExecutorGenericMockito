package com.example.task2.operations.operations_with_maps;

import static com.example.task2.VariableStorage.*;

import com.example.task2.operations.main_operations.Operation;

import java.util.HashMap;

import java.util.Map;

public class SearchInMap extends Operation {

    public SearchInMap(Map map) {
        super(map);
        setMap(map);
    }

    @Override
    public void run() {
        super.run();
    }

    @Override
    public void calculate(Object collection) {
        if (map instanceof HashMap) {
            key = SEARCH_IN_HASHMAP;
        } else {
            key = SEARCH_IN_TREEMAP;
        }
        super.calculate(map);
    }

    @Override
    public void operation(Object collection) {
        Map map = (Map) collection;
        map.containsValue("123");
    }


}