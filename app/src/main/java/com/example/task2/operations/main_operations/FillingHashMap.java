package com.example.task2.operations.main_operations;

import static com.example.task2.VariableStorage.DefOperationTags.*;

import com.example.task2.operations.operations_with_maps.*;

import java.util.Arrays;
import java.util.HashMap;

public class FillingHashMap extends FillingGeneral {
    public FillingHashMap(HashMap<Integer, String> hashMap) {
        this.hashMap = hashMap;
    }

    private final HashMap<Integer, String> hashMap;

    @Override
    public void run() {
        if (hashMap.size() != size) {
            hashMap.clear();
            for (int i = 0; i < size; i++) {
                hashMap.put(i, i + "");
            }
        }
        listOfOperations = Arrays.asList(
                new AddToMap(hashMap, ADDING_TO_HASHMAP),
                new RemoveFromMap(hashMap, REMOVE_FROM_HASHMAP),
                new SearchInMap(hashMap, SEARCH_IN_HASHMAP)
        );
        super.run();
    }
}