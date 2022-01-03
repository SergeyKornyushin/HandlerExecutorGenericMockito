package com.example.task2.fragments;

import static com.example.task2.VariableStorage.*;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.task2.interfaces.NonUIToActivityInterface;
import com.example.task2.operations.main_operations.FillingCollectionsAndMaps;
import com.example.task2.operations.main_operations.Operation;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NonUIFragment extends Fragment {

    private final Map<String, HashMap<Integer, String>> allResultsMap = new HashMap<>();
    private NonUIToActivityInterface nonUIInterface;
    private ExecutorService executorService;

    private void passAndSaveResult(int operationTag, String result) {
        if (operationTag <= REMOVE_END_COW_ARRAYLIST) {
            if (!allResultsMap.containsKey(COLLECTIONS_TAG)) {
                allResultsMap.put(COLLECTIONS_TAG, new HashMap<Integer, String>() {{
                    put(operationTag, widgets_texts.get(operationTag) + result + MS);
                }});
            } else {
                allResultsMap.get(COLLECTIONS_TAG).put(operationTag,
                        widgets_texts.get(operationTag) + result + MS);
            }
            nonUIInterface.passDataFromNonUIToUIFragment(COLLECTIONS_TAG,
                    operationTag, widgets_texts.get(operationTag) + result + MS);
        } else {
            if (!allResultsMap.containsKey(MAPS_TAG)) {
                allResultsMap.put(MAPS_TAG, new HashMap<Integer, String>() {{
                    put(operationTag, widgets_texts.get(operationTag) + result + MS);
                }});
            } else {
                allResultsMap.get(MAPS_TAG).put(operationTag,
                        widgets_texts.get(operationTag) + result + MS);
            }
            nonUIInterface.passDataFromNonUIToUIFragment(MAPS_TAG,
                    operationTag, widgets_texts.get(operationTag) + result + MS);
        }
    }

    private final Handler handler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case LIST_OR_MAP_IS_READY:
                    nonUIInterface.passInfoAboutFilling(msg.obj);
                    break;

                case ADD_TO_START_ARRAYLIST:
                    passAndSaveResult(ADD_TO_START_ARRAYLIST, msg.obj.toString());
                    break;
                case ADD_TO_START_LINKEDLIST:
                    passAndSaveResult(ADD_TO_START_LINKEDLIST, msg.obj.toString());
                    break;
                case ADD_TO_START_COW_ARRAYLIST:
                    passAndSaveResult(ADD_TO_START_COW_ARRAYLIST, msg.obj.toString());
                    break;
                case ADD_TO_MIDDLE_ARRAYLIST:
                    passAndSaveResult(ADD_TO_MIDDLE_ARRAYLIST, msg.obj.toString());
                    break;
                case ADD_TO_MIDDLE_LINKEDLIST:
                    passAndSaveResult(ADD_TO_MIDDLE_LINKEDLIST, msg.obj.toString());
                    break;
                case ADD_TO_MIDDLE_COW_ARRAYLIST:
                    passAndSaveResult(ADD_TO_MIDDLE_COW_ARRAYLIST, msg.obj.toString());
                    break;
                case ADD_TO_END_ARRAYLIST:
                    passAndSaveResult(ADD_TO_END_ARRAYLIST, msg.obj.toString());
                    break;
                case ADD_TO_END_LINKEDLIST:
                    passAndSaveResult(ADD_TO_END_LINKEDLIST, msg.obj.toString());
                    break;
                case ADD_TO_END_COW_ARRAYLIST:
                    passAndSaveResult(ADD_TO_END_COW_ARRAYLIST, msg.obj.toString());
                    break;
                case SEARCH_IN_ARRAYLIST:
                    passAndSaveResult(SEARCH_IN_ARRAYLIST, msg.obj.toString());
                    break;
                case SEARCH_IN_LINKEDLIST:
                    passAndSaveResult(SEARCH_IN_LINKEDLIST, msg.obj.toString());
                    break;
                case SEARCH_IN_COW_ARRAYLIST:
                    passAndSaveResult(SEARCH_IN_COW_ARRAYLIST, msg.obj.toString());
                    break;
                case REMOVE_BEGIN_ARRAYLIST:
                    passAndSaveResult(REMOVE_BEGIN_ARRAYLIST, msg.obj.toString());
                    break;
                case REMOVE_BEGIN_LINKEDLIST:
                    passAndSaveResult(REMOVE_BEGIN_LINKEDLIST, msg.obj.toString());
                    break;
                case REMOVE_BEGIN_COW_ARRAYLIST:
                    passAndSaveResult(REMOVE_BEGIN_COW_ARRAYLIST, msg.obj.toString());
                    break;
                case REMOVE_MIDDLE_ARRAYLIST:
                    passAndSaveResult(REMOVE_MIDDLE_ARRAYLIST, msg.obj.toString());
                    break;
                case REMOVE_MIDDLE_LINKEDLIST:
                    passAndSaveResult(REMOVE_MIDDLE_LINKEDLIST, msg.obj.toString());
                    break;
                case REMOVE_MIDDLE_COW_ARRAYLIST:
                    passAndSaveResult(REMOVE_MIDDLE_COW_ARRAYLIST, msg.obj.toString());
                    break;
                case REMOVE_END_ARRAYLIST:
                    passAndSaveResult(REMOVE_END_ARRAYLIST, msg.obj.toString());
                    break;
                case REMOVE_END_LINKEDLIST:
                    passAndSaveResult(REMOVE_END_LINKEDLIST, msg.obj.toString());
                    break;
                case REMOVE_END_COW_ARRAYLIST:
                    passAndSaveResult(REMOVE_END_COW_ARRAYLIST, msg.obj.toString());
                    break;

                case ADDING_TO_HASHMAP:
                    passAndSaveResult(ADDING_TO_HASHMAP, msg.obj.toString());
                    break;
                case ADDING_TO_TREEMAP:
                    passAndSaveResult(ADDING_TO_TREEMAP, msg.obj.toString());
                    break;
                case SEARCH_IN_HASHMAP:
                    passAndSaveResult(SEARCH_IN_HASHMAP, msg.obj.toString());
                    break;
                case SEARCH_IN_TREEMAP:
                    passAndSaveResult(SEARCH_IN_TREEMAP, msg.obj.toString());
                    break;
                case REMOVE_FROM_HASHMAP:
                    passAndSaveResult(REMOVE_FROM_HASHMAP, msg.obj.toString());
                    break;
                case REMOVE_FROM_TREEMAP:
                    passAndSaveResult(REMOVE_FROM_TREEMAP, msg.obj.toString());
                    break;
                default:
                    Log.i("test4", "not Ready solution " + msg.what);
                    break;
            }
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        HashMap<Integer, String> tempMap = new HashMap<>();
        for (int i = ADD_TO_START_ARRAYLIST; i <= REMOVE_FROM_HASHMAP; i++) {
            tempMap.put(i, NA);
        }
        allResultsMap.put(COLLECTIONS_TAG, tempMap);
        allResultsMap.put(MAPS_TAG, tempMap);

        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return null;
    }

    public void startOperations(List<Operation> list) {
        for (Operation item : list) {
            item.handler = this.handler;
            executorService.submit(item);
        }
    }

    public void createCollectionsAndMaps(String collectionOrMapTag,
                                         int collectionSize, int numberOfThreads,
                                         List<FillingCollectionsAndMaps> listCollectionsOrMaps) {
        executorService = Executors.newFixedThreadPool(numberOfThreads);
        allResultsMap.remove(collectionOrMapTag);
        for (FillingCollectionsAndMaps item : listCollectionsOrMaps) {
            item.handler = this.handler;
            item.size = collectionSize;
            executorService.submit(item);
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
        nonUIInterface.passResultsMapToUI(collectionOrMap, allResultsMap.get(collectionOrMap));
    }
}