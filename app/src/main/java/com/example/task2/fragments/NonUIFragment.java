package com.example.task2.fragments;

import static com.example.task2.VariableStorage.*;
import static com.example.task2.VariableStorage.DefOperationTags.*;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.task2.interfaces.NonUIToActivityInterface;
import com.example.task2.operations.main_operations.FillingGeneral;
import com.example.task2.operations.main_operations.Operation;
import com.example.task2.util.EspressoIdlingResource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NonUIFragment extends Fragment {

    private final Map<DefOperandTags, HashMap<DefOperationTags, String>> allResultsMap
            = new HashMap<>();
    private NonUIToActivityInterface nonUIInterface;
    private ExecutorService executorService;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        HashMap<DefOperationTags, String> tempMap = new HashMap<>();
        for (DefOperationTags item : DefOperationTags.values()) {
            tempMap.put(item, NA);
        }
        for (DefOperandTags operand : DefOperandTags.values()) {
            allResultsMap.put(operand, tempMap);
        }
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    private void passAndSaveResult(DefOperandTags operandTag, DefOperationTags operationTag, String result) {
        if (!allResultsMap.containsKey(operandTag)) {
            allResultsMap.put(operandTag, new HashMap<DefOperationTags, String>() {{
                put(operationTag, result);
            }});
        } else {
            Objects.requireNonNull(allResultsMap.get(operandTag)).put(operationTag, result);
        }
        nonUIInterface.passDataFromNonUIToUIFragment(operandTag, operationTag, result);
    }

    private Handler handler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            if (msg.what == OPERAND_IS_FILLING.ordinal()) {
                startOperations((List<Operation>) msg.obj);
            } else {
                passAndSaveResult(DefOperandTags.values()[msg.arg1],
                        DefOperationTags.values()[msg.what], msg.obj.toString());
            }
        }
    };

    public void startOperations(List<Operation> list) {
        for (Operation item : list) {
            item.handler = this.handler;
            executorService.submit(item);
        }
    }

    public void fillingOperand(DefOperandTags operandTag,
                               int collectionSize, int numberOfThreads,
                               List<FillingGeneral> listCollectionsOrMaps) {
        executorService = Executors.newFixedThreadPool(numberOfThreads);
        allResultsMap.remove(operandTag);

        for (FillingGeneral item : listCollectionsOrMaps) {
            item.handler = handler;
            item.size = collectionSize;
            executorService.submit(item);
        }
    }

    public void getResultsForUI(DefOperandTags operandTag) {
        nonUIInterface.passResultsMapToUI(operandTag, allResultsMap.get(operandTag));
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