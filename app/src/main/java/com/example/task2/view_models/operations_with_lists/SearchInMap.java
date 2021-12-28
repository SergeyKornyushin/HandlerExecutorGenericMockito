package com.example.task2.view_models.operations_with_lists;

import static com.example.task2.view_models.VariableStorage.*;

import com.example.task2.view_models.main_operations.Operation;

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
