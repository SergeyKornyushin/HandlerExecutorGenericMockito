package com.example.task2.operations.main_operations;

import static com.example.task2.VariableStorage.DefOperationTags.*;

import com.example.task2.operations.operations_with_maps.*;

import java.util.Arrays;
import java.util.TreeMap;

public class FillingTreeMap extends FillingGeneral {
    public FillingTreeMap(TreeMap<Integer, String> treeMap) {
        this.treeMap = treeMap;
    }

    private final TreeMap<Integer, String> treeMap;

    @Override
    public void run() {
        if (treeMap.size() != size) {
            treeMap.clear();
            for (int i = 0; i < size; i++) {
                treeMap.put(i, i + "");
            }
        }
        listOfOperations = Arrays.asList(
                new AddToMap(treeMap, ADDING_TO_TREEMAP),
                new RemoveFromMap(treeMap, REMOVE_FROM_TREEMAP),
                new SearchInMap(treeMap, SEARCH_IN_TREEMAP)
        );
        super.run();
    }
}