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


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NonUIFragment extends Fragment {

    private final Map<Integer, HashMap<Integer, String>> allResultsMap = new HashMap<>();
    private NonUIToActivityInterface nonUIInterface;
    private ExecutorService executorService;

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

    private void passAndSaveResult(int tagOfOperand, int operationTag, String result) {
        if (!allResultsMap.containsKey(tagOfOperand)) {
            allResultsMap.put(tagOfOperand, new HashMap<Integer, String>() {{
                put(operationTag, widgets_texts.get(operationTag) + result + MS);
            }});
        } else {
            allResultsMap.get(tagOfOperand)
                    .put(operationTag, widgets_texts.get(operationTag) + result + MS);
        }
        nonUIInterface.passDataFromNonUIToUIFragment(tagOfOperand,
                operationTag, widgets_texts.get(operationTag) + result + MS);
    }

    private final Handler handler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            if (msg.what == LIST_OR_MAP_IS_READY) {
                nonUIInterface.passInfoAboutFilling(msg.obj);
            } else {
                passAndSaveResult(msg.arg1, msg.what, msg.obj.toString());
            }
        }
    };

    public void startOperations(List<Operation> list) {
        for (Operation item : list) {
            item.handler = this.handler;
            executorService.submit(item);
        }
    }

    public void createCollectionsAndMaps(Integer collectionOrMapTag,
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

    public void getResultsForUI(Integer collectionOrMap) {
        nonUIInterface.passResultsMapToUI(collectionOrMap, allResultsMap.get(collectionOrMap));
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
}