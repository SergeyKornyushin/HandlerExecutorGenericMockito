package com.example.task2.fragments;

import static com.example.task2.view_models.VariableStorage.*;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telephony.ClosedSubscriberGroupInfo;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.task2.view_models.main_operations.FillingCollectionsAndMaps;
import com.example.task2.view_models.main_operations.Operation;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NonUIFragment extends Fragment {

    public static ArrayList<String> arrayList = new ArrayList<>();
    public static LinkedList<String> linkedList = new LinkedList<>();
    public static CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
    public static HashMap<Integer, String> hashMap = new HashMap<>();
    public static TreeMap<Integer, String> treeMap = new TreeMap<>();
    private HashMap<Integer, String> collectionsResultsMap = new HashMap<>();
    private HashMap<Integer, String> mapsResultsMap = new HashMap<>();
    private NonUIToActivityInterface nonUIInterface;
    private List<FillingCollectionsAndMaps> collectionsOperation;
    private List<FillingCollectionsAndMaps> mapsOperation;
    private ExecutorService executorService;

    private final Handler handler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case ARRAYLIST_IS_READY:
                    nonUIInterface.passInfoAboutFilling(ARRAYLIST_IS_READY);
                    break;
                case LINKEDLIST_IS_READY:
                    nonUIInterface.passInfoAboutFilling(LINKEDLIST_IS_READY);
                    break;
                case COW_ARRAYLIST_IS_READY:
                    nonUIInterface.passInfoAboutFilling(COW_ARRAYLIST_IS_READY);
                    break;
                case HASHMAP_IS_READY:
                    nonUIInterface.passInfoAboutFilling(HASHMAP_IS_READY);
                    break;
                case TREEMAP_IS_READY:
                    nonUIInterface.passInfoAboutFilling(TREEMAP_IS_READY);
                    break;

                case ADD_TO_START_ARRAYLIST:
                    nonUIInterface.passDataFromNonUIToUIFragment(COLLECTIONS_TAG, ADD_TO_START_ARRAYLIST,
                            add_to_start_arraylist + msg.obj.toString() + ms);
                    collectionsResultsMap.put(ADD_TO_START_ARRAYLIST,
                            add_to_start_arraylist + msg.obj.toString() + ms);
                    break;
                case ADD_TO_START_LINKEDLIST:
                    nonUIInterface.passDataFromNonUIToUIFragment(COLLECTIONS_TAG, ADD_TO_START_LINKEDLIST,
                            add_to_start_linkedlist + msg.obj.toString() + ms);
                    collectionsResultsMap.put(ADD_TO_START_LINKEDLIST,
                            add_to_start_linkedlist + msg.obj.toString() + ms);
                    break;
                case ADD_TO_START_COW_ARRAYLIST:
                    nonUIInterface.passDataFromNonUIToUIFragment(COLLECTIONS_TAG, ADD_TO_START_COW_ARRAYLIST,
                            add_to_start_cow_arraylist + msg.obj.toString() + ms);
                    collectionsResultsMap.put(ADD_TO_START_COW_ARRAYLIST,
                            add_to_start_cow_arraylist + msg.obj.toString() + ms);
                    break;
                case ADD_TO_MIDDLE_ARRAYLIST:
                    nonUIInterface.passDataFromNonUIToUIFragment(COLLECTIONS_TAG, ADD_TO_MIDDLE_ARRAYLIST,
                            add_to_middle_arraylist + msg.obj.toString() + ms);
                    collectionsResultsMap.put(ADD_TO_MIDDLE_ARRAYLIST,
                            add_to_middle_arraylist + msg.obj.toString() + ms);
                    break;
                case ADD_TO_MIDDLE_LINKEDLIST:
                    nonUIInterface.passDataFromNonUIToUIFragment(COLLECTIONS_TAG, ADD_TO_MIDDLE_LINKEDLIST,
                            add_to_middle_linkedlist + msg.obj.toString() + ms);
                    collectionsResultsMap.put(ADD_TO_MIDDLE_LINKEDLIST,
                            add_to_middle_linkedlist + msg.obj.toString() + ms);
                    break;
                case ADD_TO_MIDDLE_COW_ARRAYLIST:
                    nonUIInterface.passDataFromNonUIToUIFragment(COLLECTIONS_TAG, ADD_TO_MIDDLE_COW_ARRAYLIST,
                            add_to_middle_cow_arraylist + msg.obj.toString() + ms);
                    collectionsResultsMap.put(ADD_TO_MIDDLE_COW_ARRAYLIST,
                            add_to_middle_cow_arraylist + msg.obj.toString() + ms);
                    break;
                case ADD_TO_END_ARRAYLIST:
                    nonUIInterface.passDataFromNonUIToUIFragment(COLLECTIONS_TAG, ADD_TO_END_ARRAYLIST,
                            add_to_end_arraylist + msg.obj.toString() + ms);
                    collectionsResultsMap.put(ADD_TO_END_ARRAYLIST,
                            add_to_end_arraylist + msg.obj.toString() + ms);
                    break;
                case ADD_TO_END_LINKEDLIST:
                    nonUIInterface.passDataFromNonUIToUIFragment(COLLECTIONS_TAG, ADD_TO_END_LINKEDLIST,
                            add_to_end_linkedlist + msg.obj.toString() + ms);
                    collectionsResultsMap.put(ADD_TO_END_LINKEDLIST,
                            add_to_end_linkedlist + msg.obj.toString() + ms);
                    break;
                case ADD_TO_END_COW_ARRAYLIST:
                    nonUIInterface.passDataFromNonUIToUIFragment(COLLECTIONS_TAG, ADD_TO_END_COW_ARRAYLIST,
                            add_to_end_cow_arraylist + msg.obj.toString() + ms);
                    collectionsResultsMap.put(ADD_TO_END_COW_ARRAYLIST,
                            add_to_end_cow_arraylist + msg.obj.toString() + ms);
                    break;
                case SEARCH_IN_ARRAYLIST:
                    nonUIInterface.passDataFromNonUIToUIFragment(COLLECTIONS_TAG, SEARCH_IN_ARRAYLIST,
                            search_in_arraylist + msg.obj.toString() + ms);
                    collectionsResultsMap.put(SEARCH_IN_ARRAYLIST,
                            search_in_arraylist + msg.obj.toString() + ms);
                    break;
                case SEARCH_IN_LINKEDLIST:
                    nonUIInterface.passDataFromNonUIToUIFragment(COLLECTIONS_TAG, SEARCH_IN_LINKEDLIST,
                            search_in_linkedlist + msg.obj.toString() + ms);
                    collectionsResultsMap.put(SEARCH_IN_LINKEDLIST,
                            search_in_linkedlist + msg.obj.toString() + ms);
                    break;
                case SEARCH_IN_COW_ARRAYLIST:
                    nonUIInterface.passDataFromNonUIToUIFragment(COLLECTIONS_TAG, SEARCH_IN_COW_ARRAYLIST,
                            search_in_cow_arraylist + msg.obj.toString() + ms);
                    collectionsResultsMap.put(SEARCH_IN_COW_ARRAYLIST,
                            search_in_cow_arraylist + msg.obj.toString() + ms);
                    break;
                case REMOVE_BEGIN_ARRAYLIST:
                    nonUIInterface.passDataFromNonUIToUIFragment(COLLECTIONS_TAG, REMOVE_BEGIN_ARRAYLIST,
                            removing_from_start_arraylist + msg.obj.toString() + ms);
                    collectionsResultsMap.put(REMOVE_BEGIN_ARRAYLIST,
                            removing_from_start_arraylist + msg.obj.toString() + ms);
                    break;
                case REMOVE_BEGIN_LINKEDLIST:
                    nonUIInterface.passDataFromNonUIToUIFragment(COLLECTIONS_TAG, REMOVE_BEGIN_LINKEDLIST,
                            removing_from_start_linkedlist + msg.obj.toString() + ms);
                    collectionsResultsMap.put(REMOVE_BEGIN_LINKEDLIST,
                            removing_from_start_linkedlist + msg.obj.toString() + ms);
                    break;
                case REMOVE_BEGIN_COW_ARRAYLIST:
                    nonUIInterface.passDataFromNonUIToUIFragment(COLLECTIONS_TAG, REMOVE_BEGIN_COW_ARRAYLIST,
                            removing_from_start_cow_arraylist + msg.obj.toString() + ms);
                    collectionsResultsMap.put(REMOVE_BEGIN_COW_ARRAYLIST,
                            removing_from_start_cow_arraylist + msg.obj.toString() + ms);
                    break;
                case REMOVE_MIDDLE_ARRAYLIST:
                    nonUIInterface.passDataFromNonUIToUIFragment(COLLECTIONS_TAG, REMOVE_MIDDLE_ARRAYLIST,
                            removing_from_middle_arraylist + msg.obj.toString() + ms);
                    collectionsResultsMap.put(REMOVE_MIDDLE_ARRAYLIST,
                            removing_from_middle_arraylist + msg.obj.toString() + ms);
                    break;
                case REMOVE_MIDDLE_LINKEDLIST:
                    nonUIInterface.passDataFromNonUIToUIFragment(COLLECTIONS_TAG, REMOVE_MIDDLE_LINKEDLIST,
                            removing_from_middle_linkedlist + msg.obj.toString() + ms);
                    collectionsResultsMap.put(REMOVE_MIDDLE_LINKEDLIST,
                            removing_from_middle_linkedlist + msg.obj.toString() + ms);
                    break;
                case REMOVE_MIDDLE_COW_ARRAYLIST:
                    nonUIInterface.passDataFromNonUIToUIFragment(COLLECTIONS_TAG, REMOVE_MIDDLE_COW_ARRAYLIST,
                            removing_from_middle_cow_arraylist + msg.obj.toString() + ms);
                    collectionsResultsMap.put(REMOVE_MIDDLE_COW_ARRAYLIST,
                            removing_from_middle_cow_arraylist + msg.obj.toString() + ms);
                    break;
                case REMOVE_END_ARRAYLIST:
                    nonUIInterface.passDataFromNonUIToUIFragment(COLLECTIONS_TAG, REMOVE_END_ARRAYLIST,
                            removing_from_end_arraylist + msg.obj.toString() + ms);
                    collectionsResultsMap.put(REMOVE_END_ARRAYLIST,
                            removing_from_end_arraylist + msg.obj.toString() + ms);
                    break;
                case REMOVE_END_LINKEDLIST:
                    nonUIInterface.passDataFromNonUIToUIFragment(COLLECTIONS_TAG, REMOVE_END_LINKEDLIST,
                            removing_from_end_linkedlist + msg.obj.toString() + ms);
                    collectionsResultsMap.put(REMOVE_END_LINKEDLIST,
                            removing_from_end_linkedlist + msg.obj.toString() + ms);
                    break;
                case REMOVE_END_COW_ARRAYLIST:
                    nonUIInterface.passDataFromNonUIToUIFragment(COLLECTIONS_TAG, REMOVE_END_COW_ARRAYLIST,
                            removing_from_end_cow_arraylist + msg.obj.toString() + ms);
                    collectionsResultsMap.put(REMOVE_END_COW_ARRAYLIST,
                            removing_from_end_cow_arraylist + msg.obj.toString() + ms);
                    break;

                case ADDING_TO_HASHMAP:
                    nonUIInterface.passDataFromNonUIToUIFragment(MAPS_TAG, ADDING_TO_HASHMAP,
                            add_to_hashmap + msg.obj.toString() + ms);
                    mapsResultsMap.put(ADDING_TO_HASHMAP,
                            add_to_hashmap + msg.obj.toString() + ms);
                    break;
                case ADDING_TO_TREEMAP:
                    nonUIInterface.passDataFromNonUIToUIFragment(MAPS_TAG, ADDING_TO_TREEMAP,
                            add_to_treemap + msg.obj.toString() + ms);
                    mapsResultsMap.put(ADDING_TO_TREEMAP,
                            add_to_treemap + msg.obj.toString() + ms);
                    break;
                case SEARCH_IN_HASHMAP:
                    nonUIInterface.passDataFromNonUIToUIFragment(MAPS_TAG, SEARCH_IN_HASHMAP,
                            search_in_hashmap + msg.obj.toString() + ms);
                    mapsResultsMap.put(SEARCH_IN_HASHMAP,
                            search_in_hashmap + msg.obj.toString() + ms);
                    break;
                case SEARCH_IN_TREEMAP:
                    nonUIInterface.passDataFromNonUIToUIFragment(MAPS_TAG, SEARCH_IN_TREEMAP,
                            search_in_treemap + msg.obj.toString() + ms);
                    mapsResultsMap.put(SEARCH_IN_TREEMAP,
                            search_in_treemap + msg.obj.toString() + ms);
                    break;
                case REMOVE_FROM_HASHMAP:
                    nonUIInterface.passDataFromNonUIToUIFragment(MAPS_TAG, REMOVE_FROM_HASHMAP,
                            removing_from_hashmap + msg.obj.toString() + ms);
                    mapsResultsMap.put(REMOVE_FROM_HASHMAP,
                            removing_from_hashmap + msg.obj.toString() + ms);
                    break;
                case REMOVE_FROM_TREEMAP:
                    nonUIInterface.passDataFromNonUIToUIFragment(MAPS_TAG, REMOVE_FROM_TREEMAP,
                            removing_from_treemap + msg.obj.toString() + ms);
                    mapsResultsMap.put(REMOVE_FROM_TREEMAP,
                            removing_from_treemap + msg.obj.toString() + ms);
                    break;
                default:
                    Log.i("test4", "not Ready solution " + msg.what);
                    break;
            }
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        for (int i = ADD_TO_START_ARRAYLIST; i <= REMOVE_END_COW_ARRAYLIST; i++){
            collectionsResultsMap.put(i, NA);
        }
        for (int i = ADDING_TO_TREEMAP; i <= REMOVE_FROM_HASHMAP; i++){
            mapsResultsMap.put(i, NA);
        }
            super.onCreate(savedInstanceState);
        setRetainInstance(true);
        collectionsOperation = Arrays.asList(
                new FillingCollectionsAndMaps(arrayList),
                new FillingCollectionsAndMaps(linkedList),
                new FillingCollectionsAndMaps(copyOnWriteArrayList)
        );
        mapsOperation = Arrays.asList(
                new FillingCollectionsAndMaps(hashMap),
                new FillingCollectionsAndMaps(treeMap)
        );
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return null;
    }

    public void startOperations(List<Operation> list) throws ExecutionException, InterruptedException {
        for (Operation item : list) {
            item.handler = this.handler;
            executorService.submit(item);
        }
    }

    public void createCollectionsAndMaps(String collectionOrMapTag, int collectionSize, int numberOfThreads)
            throws ExecutionException, InterruptedException {
        executorService = Executors.newFixedThreadPool(numberOfThreads);
        if (collectionOrMapTag == COLLECTIONS_TAG) {
            collectionsResultsMap.clear();
            for (FillingCollectionsAndMaps item : collectionsOperation) {
                item.handler = this.handler;
                item.size = collectionSize;
                executorService.submit(item);
            }
        } else {
            mapsResultsMap.clear();
            for (FillingCollectionsAndMaps item : mapsOperation) {
                item.handler = this.handler;
                item.size = collectionSize;
                executorService.submit(item);
            }
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        nonUIInterface = (NonUIToActivityInterface) getContext();
        super.onAttach(context);
    }

    @Override
    public void onDestroy() {
        executorService.shutdown();
        super.onDestroy();
    }

    public void getResultsForUI(String collectionOrMap) {
        if (collectionOrMap == COLLECTIONS_TAG) {
            nonUIInterface.passResultsMapToUI(collectionOrMap, collectionsResultsMap);
        } else {
            nonUIInterface.passResultsMapToUI(collectionOrMap, mapsResultsMap);
        }
    }
}


