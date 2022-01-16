package com.example.task2.operations.main_operations;

import static com.example.task2.VariableStorage.DefOperationTags.*;

import com.example.task2.operations.operations_with_lists.*;

import java.util.Arrays;
import java.util.LinkedList;

public class FillingLinkedList extends FillingGeneral {
    public FillingLinkedList(LinkedList<String> linkedList) {
        this.linkedList = linkedList;
    }

    private final LinkedList<String> linkedList;

    @Override
    public void run() {
        if (linkedList.size() != size) {
            linkedList.clear();
            for (int i = 0; i < size; i++) {
                linkedList.add(i + "");
            }
        }
        listOfOperations = Arrays.asList(
                new AddToStartList(linkedList, ADD_TO_START_LINKEDLIST),
                new AddToMiddleList(linkedList, ADD_TO_MIDDLE_LINKEDLIST),
                new AddToEndList(linkedList, ADD_TO_END_LINKEDLIST),
                new SearchInList(linkedList, SEARCH_IN_LINKEDLIST),
                new RemoveStartList(linkedList, REMOVE_BEGIN_LINKEDLIST),
                new RemoveMiddleList(linkedList, REMOVE_MIDDLE_LINKEDLIST),
                new RemoveEndList(linkedList, REMOVE_END_LINKEDLIST)
        );
        super.run();
    }
}