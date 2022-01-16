package com.example.task2;

import static com.example.task2.VariableStorage.DefOperationTags.*;
import java.util.HashMap;

public class VariableStorage {

    public enum DefOperandTags {
        COLLECTIONS_TAG, MAPS_TAG
    }

    public enum DefOperationTags{
        OPERAND_IS_FILLING,

        ADD_TO_START_ARRAYLIST, ADD_TO_START_LINKEDLIST, ADD_TO_START_COW_ARRAYLIST,
        ADD_TO_MIDDLE_ARRAYLIST, ADD_TO_MIDDLE_LINKEDLIST, ADD_TO_MIDDLE_COW_ARRAYLIST,
        ADD_TO_END_ARRAYLIST, ADD_TO_END_LINKEDLIST, ADD_TO_END_COW_ARRAYLIST,
        SEARCH_IN_ARRAYLIST, SEARCH_IN_LINKEDLIST, SEARCH_IN_COW_ARRAYLIST,
        REMOVE_BEGIN_ARRAYLIST, REMOVE_BEGIN_LINKEDLIST, REMOVE_BEGIN_COW_ARRAYLIST,
        REMOVE_MIDDLE_ARRAYLIST, REMOVE_MIDDLE_LINKEDLIST, REMOVE_MIDDLE_COW_ARRAYLIST,
        REMOVE_END_ARRAYLIST, REMOVE_END_LINKEDLIST, REMOVE_END_COW_ARRAYLIST,

        ADDING_TO_TREEMAP, SEARCH_IN_TREEMAP, REMOVE_FROM_TREEMAP,
        ADDING_TO_HASHMAP, SEARCH_IN_HASHMAP, REMOVE_FROM_HASHMAP
    }

    public static final int NON_USABLE_ARGUMENT = 99;
    public static final String DEFAULT_COLLECTION_SIZE = "20000";
    public static final String DEFAULT_NUMBER_OF_THREADS = "9";

    public static final String NA = "N/A";
    public static final String MS = " ms";

    public static final HashMap<DefOperationTags, String> widgets_texts =
            new HashMap<DefOperationTags, String>() {{
        put(ADD_TO_START_ARRAYLIST, "Adding to start of ArrayList: \n");
        put(ADD_TO_START_LINKEDLIST, "Adding to start of LinkedList: \n");
        put(ADD_TO_START_COW_ARRAYLIST, "Adding to start in CopyOnWriteArrayList: \n");
        put(ADD_TO_MIDDLE_ARRAYLIST, "Adding to middle of ArrayList: \n");
        put(ADD_TO_MIDDLE_LINKEDLIST, "Adding to middle of LinkedList: \n");
        put(ADD_TO_MIDDLE_COW_ARRAYLIST, "Adding to middle of CopyOnWriteArrayList: \n");
        put(ADD_TO_END_ARRAYLIST, "Adding to end of ArrayList: \n");
        put(ADD_TO_END_LINKEDLIST, "Adding to end of LinkedList: \n");
        put(ADD_TO_END_COW_ARRAYLIST, "Adding to end of CopyOnWriteArrayList: \n");
        put(SEARCH_IN_ARRAYLIST, "Search in ArrayList: \n");
        put(SEARCH_IN_LINKEDLIST, "Search in LinkedList: \n");
        put(SEARCH_IN_COW_ARRAYLIST, "Search in CopyOnWriteArrayList: \n");
        put(REMOVE_BEGIN_ARRAYLIST, "Removing from start of ArrayList: \n");
        put(REMOVE_BEGIN_LINKEDLIST, "Removing from start of LinkedList: \n");
        put(REMOVE_BEGIN_COW_ARRAYLIST, "Removing from start of CopyOnWriteArrayList: \n");
        put(REMOVE_MIDDLE_ARRAYLIST, "Removing from middle of ArrayList: \n");
        put(REMOVE_MIDDLE_LINKEDLIST, "Removing from middle of LinkedList: \n");
        put(REMOVE_MIDDLE_COW_ARRAYLIST, "Removing from middle of CopyOnWriteArrayList: \n");
        put(REMOVE_END_ARRAYLIST, "Removing from end of ArrayList: \n");
        put(REMOVE_END_LINKEDLIST, "Removing from end of LinkedList: \n");
        put(REMOVE_END_COW_ARRAYLIST, "Removing from end of CopyOnWriteArrayList: \n");
        put(ADDING_TO_TREEMAP, "Adding to TreeMap: \n");
        put(SEARCH_IN_TREEMAP, "Search in TreeMap: \n");
        put(REMOVE_FROM_TREEMAP, "Removing from TreeMap: \n");
        put(ADDING_TO_HASHMAP, "Adding to HashMap: \n");
        put(SEARCH_IN_HASHMAP, "Search in HashMap: \n");
        put(REMOVE_FROM_HASHMAP, "Removing from HashMap: \n");
    }};
}