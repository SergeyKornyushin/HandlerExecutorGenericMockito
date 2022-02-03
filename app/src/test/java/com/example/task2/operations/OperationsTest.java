package com.example.task2.operations;

import static com.example.task2.VariableStorage.DefOperationTags.*;
import static org.junit.Assert.*;

import com.example.task2.operations.operations_with_lists.AddToEndList;
import com.example.task2.operations.operations_with_lists.AddToMiddleList;
import com.example.task2.operations.operations_with_lists.AddToStartList;
import com.example.task2.operations.operations_with_lists.RemoveEndList;
import com.example.task2.operations.operations_with_lists.RemoveMiddleList;
import com.example.task2.operations.operations_with_lists.RemoveStartList;
import com.example.task2.operations.operations_with_lists.SearchInList;
import com.example.task2.operations.operations_with_maps.AddToMap;
import com.example.task2.operations.operations_with_maps.RemoveFromMap;
import com.example.task2.operations.operations_with_maps.SearchInMap;
import com.google.common.util.concurrent.MoreExecutors;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

public class OperationsTest {
    private ExecutorService executorService;
    private static final String ADDED_ELEMENT = "123";
    private static final int operandSize = 200;
    private final ArrayList<String> arrayList = new ArrayList<>();
    private final LinkedList<String> linkedList = new LinkedList<>();
    private final CopyOnWriteArrayList<String> cOWArrayList = new CopyOnWriteArrayList<>();
    private final HashMap<Integer, String> hashMap = new HashMap<>();
    private final TreeMap<Integer, String> treeMap = new TreeMap<>();

    @Before
    public void setUp() {
        executorService = MoreExecutors.newDirectExecutorService();
    }

    //---ArrayList---
    @Test
    public void add_to_start_arraylist_test() throws InterruptedException {
        for (int i = 0; i < operandSize; i++) {
            arrayList.add(i + "");
        }
        AddToStartList addToStartList = new AddToStartList(arrayList, TAG_FOR_TESTS);
        executorService.submit(addToStartList);

        assertEquals(ADDED_ELEMENT, arrayList.get(0));
    }

    @Test
    public void add_to_middle_arraylist_test() throws InterruptedException {
        for (int i = 0; i < operandSize; i++) {
            arrayList.add(i + "");
        }
        AddToMiddleList addToMiddleList = new AddToMiddleList(arrayList, TAG_FOR_TESTS);
        executorService.submit(addToMiddleList);

        assertEquals(ADDED_ELEMENT, arrayList.get(arrayList.size() / 2));
    }

    @Test
    public void add_to_end_arraylist_test() throws InterruptedException {
        for (int i = 0; i < operandSize; i++) {
            arrayList.add(i + "");
        }
        AddToEndList addToEndList = new AddToEndList(arrayList, TAG_FOR_TESTS);
        executorService.submit(addToEndList);

        assertEquals(ADDED_ELEMENT, arrayList.get(arrayList.size() - 4));
    }

    @Test
    public void search_in_arraylist_test() throws InterruptedException {
        for (int i = 0; i < operandSize; i++) {
            arrayList.add(i + "");
        }
        arrayList.add(ADDED_ELEMENT);
        SearchInList searchInList = new SearchInList(arrayList, TAG_FOR_TESTS);
        executorService.submit(searchInList);

        assertTrue(arrayList.contains(ADDED_ELEMENT));
    }

    @Test
    public void remove_from_start_arraylist_test() throws InterruptedException {
        arrayList.add(ADDED_ELEMENT);
        for (int i = 0; i < operandSize; i++) {
            arrayList.add(i + "|");
        }
        RemoveStartList removeStartList = new RemoveStartList(arrayList, TAG_FOR_TESTS);
        executorService.submit(removeStartList);

        assertFalse(arrayList.contains(ADDED_ELEMENT));
    }

    @Test
    public void remove_from_middle_arraylist_test() throws InterruptedException {
        for (int i = 0; i < operandSize / 2; i++) {
            arrayList.add(i + "|");
        }
        arrayList.add(ADDED_ELEMENT);
        for (int i = 0; i < operandSize / 2; i++) {
            arrayList.add(i + "|");
        }
        RemoveMiddleList removeMiddleList = new RemoveMiddleList(arrayList, TAG_FOR_TESTS);
        executorService.submit(removeMiddleList);

        assertFalse(arrayList.contains(ADDED_ELEMENT));
    }

    @Test
    public void remove_from_end_arraylist_test() throws InterruptedException {
        for (int i = 0; i < operandSize; i++) {
            arrayList.add(i + "|");
        }
        arrayList.add(ADDED_ELEMENT);
        arrayList.add("|");
        arrayList.add("|");

        RemoveEndList removeEndList = new RemoveEndList(arrayList, TAG_FOR_TESTS);
        executorService.submit(removeEndList);

        assertFalse(arrayList.contains(ADDED_ELEMENT));
    }

    //---LinkedList---
    @Test
    public void add_to_start_linkedlist_test() throws InterruptedException {
        for (int i = 0; i < operandSize; i++) {
            linkedList.add(i + "");
        }
        AddToStartList addToStartList = new AddToStartList(linkedList, TAG_FOR_TESTS);
        executorService.submit(addToStartList);

        assertEquals(ADDED_ELEMENT, linkedList.get(0));
    }

    @Test
    public void add_to_middle_linkedlist_test() throws InterruptedException {
        for (int i = 0; i < operandSize; i++) {
            linkedList.add(i + "");
        }
        AddToMiddleList addToMiddleList = new AddToMiddleList(linkedList, TAG_FOR_TESTS);
        executorService.submit(addToMiddleList);

        assertEquals(ADDED_ELEMENT, linkedList.get(linkedList.size() / 2));
    }

    @Test
    public void add_to_end_linkedlist_test() throws InterruptedException {
        for (int i = 0; i < operandSize; i++) {
            linkedList.add(i + "");
        }
        AddToEndList addToEndList = new AddToEndList(linkedList, TAG_FOR_TESTS);
        executorService.submit(addToEndList);

        assertEquals(ADDED_ELEMENT, linkedList.get(linkedList.size() - 4));
    }

    @Test
    public void search_in_linkedlist_test() throws InterruptedException {
        for (int i = 0; i < operandSize; i++) {
            linkedList.add(i + "");
        }
        linkedList.add(ADDED_ELEMENT);
        SearchInList searchInList = new SearchInList(linkedList, TAG_FOR_TESTS);
        executorService.submit(searchInList);

        assertTrue(linkedList.contains(ADDED_ELEMENT));
    }

    @Test
    public void remove_from_start_linkedlist_test() throws InterruptedException {
        linkedList.add(ADDED_ELEMENT);
        for (int i = 0; i < operandSize; i++) {
            linkedList.add(i + "|");
        }
        RemoveStartList removeStartList = new RemoveStartList(linkedList, TAG_FOR_TESTS);
        executorService.submit(removeStartList);

        assertFalse(linkedList.contains(ADDED_ELEMENT));
    }

    @Test
    public void remove_from_middle_linkedList_test() throws InterruptedException {
        for (int i = 0; i < operandSize / 2; i++) {
            linkedList.add(i + "|");
        }
        linkedList.add(ADDED_ELEMENT);
        for (int i = 0; i < operandSize / 2; i++) {
            linkedList.add(i + "|");
        }
        RemoveMiddleList removeMiddleList = new RemoveMiddleList(linkedList, TAG_FOR_TESTS);
        executorService.submit(removeMiddleList);

        assertFalse(linkedList.contains(ADDED_ELEMENT));
    }

    @Test
    public void remove_from_end_linkedList_test() throws InterruptedException {
        for (int i = 0; i < operandSize; i++) {
            linkedList.add(i + "|");
        }
        linkedList.add(ADDED_ELEMENT);
        linkedList.add("|");
        linkedList.add("|");

        RemoveEndList removeEndList = new RemoveEndList(linkedList, TAG_FOR_TESTS);
        executorService.submit(removeEndList);

        assertFalse(linkedList.contains(ADDED_ELEMENT));
    }

    //---COWArrayList---
    @Test
    public void add_to_start_cowarraylist_test() throws InterruptedException {
        for (int i = 0; i < operandSize; i++) {
            cOWArrayList.add(i + "");
        }
        AddToStartList addToStartList = new AddToStartList(cOWArrayList, TAG_FOR_TESTS);
        executorService.submit(addToStartList);

        assertEquals(ADDED_ELEMENT, cOWArrayList.get(0));
    }

    @Test
    public void add_to_middle_cowarraylist_test() throws InterruptedException {
        for (int i = 0; i < operandSize; i++) {
            cOWArrayList.add(i + "");
        }
        AddToMiddleList addToMiddleList = new AddToMiddleList(cOWArrayList, TAG_FOR_TESTS);
        executorService.submit(addToMiddleList);

        assertEquals(ADDED_ELEMENT, cOWArrayList.get(cOWArrayList.size() / 2));
    }

    @Test
    public void add_to_end_cowarraylist_test() throws InterruptedException {
        for (int i = 0; i < operandSize; i++) {
            cOWArrayList.add(i + "");
        }
        AddToEndList addToEndList = new AddToEndList(cOWArrayList, TAG_FOR_TESTS);
        executorService.submit(addToEndList);

        assertEquals(ADDED_ELEMENT, cOWArrayList.get(cOWArrayList.size() - 4));
    }

    @Test
    public void search_in_cowarraylist_test() throws InterruptedException {
        for (int i = 0; i < operandSize; i++) {
            cOWArrayList.add(i + "");
        }
        cOWArrayList.add(ADDED_ELEMENT);
        SearchInList searchInList = new SearchInList(cOWArrayList, TAG_FOR_TESTS);
        executorService.submit(searchInList);

        assertTrue(cOWArrayList.contains(ADDED_ELEMENT));
    }

    @Test
    public void remove_from_start_cow_arraylist_test() throws InterruptedException {
        cOWArrayList.add(ADDED_ELEMENT);
        for (int i = 0; i < operandSize; i++) {
            cOWArrayList.add(i + "|");
        }
        RemoveStartList removeStartList = new RemoveStartList(cOWArrayList, TAG_FOR_TESTS);
        executorService.submit(removeStartList);

        assertFalse(cOWArrayList.contains(ADDED_ELEMENT));
    }

    @Test
    public void remove_from_middle_cow_arraylist_test() throws InterruptedException {
        for (int i = 0; i < operandSize / 2; i++) {
            cOWArrayList.add(i + "|");
        }
        cOWArrayList.add(ADDED_ELEMENT);
        for (int i = 0; i < operandSize / 2; i++) {
            cOWArrayList.add(i + "|");
        }
        RemoveMiddleList removeMiddleList = new RemoveMiddleList(cOWArrayList, TAG_FOR_TESTS);
        executorService.submit(removeMiddleList);

        assertFalse(cOWArrayList.contains(ADDED_ELEMENT));
    }

    @Test
    public void remove_from_end_cow_arraylist_test() throws InterruptedException {
        for (int i = 0; i < operandSize; i++) {
            cOWArrayList.add(i + "|");
        }
        cOWArrayList.add(ADDED_ELEMENT);
        cOWArrayList.add("|");
        cOWArrayList.add("|");

        RemoveEndList removeEndList = new RemoveEndList(cOWArrayList, TAG_FOR_TESTS);
        executorService.submit(removeEndList);

        assertFalse(cOWArrayList.contains(ADDED_ELEMENT));
    }

    //---TreeMap---
    @Test
    public void add_to_treemap_test() throws InterruptedException {
        for (int i = 0; i < operandSize; i++) {
            treeMap.put(i, i + "");
        }
        AddToMap addToMap = new AddToMap(treeMap, TAG_FOR_TESTS);
        executorService.submit(addToMap);

        assertEquals(ADDED_ELEMENT, treeMap.get(treeMap.size() - 1));
    }

    @Test
    public void remove_from_treemap_test() throws InterruptedException {
        for (int i = 0; i < operandSize; i++) {
            treeMap.put(i, i + "");
        }
        RemoveFromMap removeFromMap = new RemoveFromMap(treeMap, TAG_FOR_TESTS);
        executorService.submit(removeFromMap);

        assertEquals(operandSize - 1, treeMap.size());
    }

    @Test
    public void search_in_treemap_test() throws InterruptedException {
        for (int i = 0; i < operandSize; i++) {
            treeMap.put(i, i + "");
        }
        treeMap.put(operandSize, ADDED_ELEMENT);
        SearchInMap searchInMap = new SearchInMap(treeMap, TAG_FOR_TESTS);
        executorService.submit(searchInMap);

        assertTrue(treeMap.containsValue(ADDED_ELEMENT));
    }

    //---hashmap---
    @Test
    public void add_to_hashmap_test() throws InterruptedException {
        for (int i = 0; i < operandSize; i++) {
            hashMap.put(i, i + "");
        }
        AddToMap addToMap = new AddToMap(hashMap, TAG_FOR_TESTS);
        executorService.submit(addToMap);

        assertEquals(ADDED_ELEMENT, hashMap.get(hashMap.size() - 1));
    }

    @Test
    public void remove_from_hashMap_test() throws InterruptedException {
        for (int i = 0; i < operandSize; i++) {
            hashMap.put(i, i + "");
        }
        RemoveFromMap removeFromMap = new RemoveFromMap(hashMap, TAG_FOR_TESTS);
        executorService.submit(removeFromMap);

        assertEquals(operandSize - 1, hashMap.size());
    }

    @Test
    public void search_in_hashMap_test() throws InterruptedException {
        for (int i = 0; i < operandSize; i++) {
            hashMap.put(i, i + "");
        }
        hashMap.put(operandSize, ADDED_ELEMENT);
        SearchInMap searchInMap = new SearchInMap(hashMap, TAG_FOR_TESTS);
        executorService.submit(searchInMap);

        assertTrue(hashMap.containsValue(ADDED_ELEMENT));
    }
}