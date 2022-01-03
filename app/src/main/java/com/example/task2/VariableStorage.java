package com.example.task2;

import java.util.HashMap;

public class VariableStorage {
    public static final String COLLECTIONS_TAG = "f0";
    public static final String MAPS_TAG = "f1";

    public static final String DEFAULT_COLLECTION_SIZE = "20000";
    public static final String DEFAULT_NUMBER_OF_THREADS = "9";

    public static final int LIST_OR_MAP_IS_READY = 0;

    public static final int ADD_TO_START_ARRAYLIST = 1;
    public static final int ADD_TO_START_LINKEDLIST = 2;
    public static final int ADD_TO_START_COW_ARRAYLIST = 3;
    public static final int ADD_TO_MIDDLE_ARRAYLIST = 4;
    public static final int ADD_TO_MIDDLE_LINKEDLIST = 5;
    public static final int ADD_TO_MIDDLE_COW_ARRAYLIST = 6;
    public static final int ADD_TO_END_ARRAYLIST = 7;
    public static final int ADD_TO_END_LINKEDLIST = 8;
    public static final int ADD_TO_END_COW_ARRAYLIST = 9;
    public static final int SEARCH_IN_ARRAYLIST = 10;
    public static final int SEARCH_IN_LINKEDLIST = 11;
    public static final int SEARCH_IN_COW_ARRAYLIST = 12;
    public static final int REMOVE_BEGIN_ARRAYLIST = 13;
    public static final int REMOVE_BEGIN_LINKEDLIST = 14;
    public static final int REMOVE_BEGIN_COW_ARRAYLIST = 15;
    public static final int REMOVE_MIDDLE_ARRAYLIST = 16;
    public static final int REMOVE_MIDDLE_LINKEDLIST = 17;
    public static final int REMOVE_MIDDLE_COW_ARRAYLIST = 18;
    public static final int REMOVE_END_ARRAYLIST = 19;
    public static final int REMOVE_END_LINKEDLIST = 20;
    public static final int REMOVE_END_COW_ARRAYLIST = 21;

    public static final int ADDING_TO_TREEMAP = 22;
    public static final int SEARCH_IN_TREEMAP = 23;
    public static final int REMOVE_FROM_TREEMAP = 24;
    public static final int ADDING_TO_HASHMAP = 25;
    public static final int SEARCH_IN_HASHMAP = 26;
    public static final int REMOVE_FROM_HASHMAP = 27;

    public static final HashMap<Integer, String> widgets_texts = new HashMap<Integer, String>(){{
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

    public static final String NA = "N/A";
    public static final String MS = " ms";

}