package com.example.task2.fragments;

import static com.example.task2.VariableStorage.*;
import static com.example.task2.VariableStorage.DefOperandTags.*;
import static com.example.task2.VariableStorage.DefOperationTags.*;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.task2.customView.TextWithPB;
import com.example.task2.databinding.FragmentMapBinding;
import com.example.task2.interfaces.FragmentsGeneralMethodsInterface;
import com.example.task2.interfaces.UIToActivityInterface;
import com.example.task2.operations.main_operations.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class MapsFragment extends Fragment
        implements FragmentsGeneralMethodsInterface {
    private static final HashMap<Integer, String> hashMap = new HashMap<>();
    private static final TreeMap<Integer, String> treeMap = new TreeMap<>();
    private FragmentMapBinding fragmentMBinding;
    private UIToActivityInterface uIInterface;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        uIInterface = (UIToActivityInterface) getActivity();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentMBinding = FragmentMapBinding.inflate(getLayoutInflater());

        fragmentMBinding.tvAddToTreeMap.setTag(ADDING_TO_TREEMAP);
        fragmentMBinding.tvAddToHashMap.setTag(ADDING_TO_HASHMAP);
        fragmentMBinding.tvSearchInTreeMap.setTag(SEARCH_IN_TREEMAP);
        fragmentMBinding.tvSearchInHashMap.setTag(SEARCH_IN_HASHMAP);
        fragmentMBinding.tvRemoveFromTreeMap.setTag(REMOVE_FROM_TREEMAP);
        fragmentMBinding.tvRemoveFromHashMap.setTag(REMOVE_FROM_HASHMAP);

        uIInterface.requestResultsForUI(MAPS_TAG);

        return fragmentMBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fragmentMBinding.btnStartMaps.setOnClickListener(view1 -> {
            setProgressBarVisibility();
            if (fragmentMBinding.etThreadsNumber.getText().toString().equals("")) {
                fragmentMBinding.etThreadsNumber.setText(DEFAULT_NUMBER_OF_THREADS);
            }
            if (fragmentMBinding.etOperationNumber.getText().toString().equals("")) {
                fragmentMBinding.etOperationNumber.setText(DEFAULT_COLLECTION_SIZE);
            }

            List<FillingGeneral> listOfMaps = Arrays.asList(
                    new FillingHashMap(hashMap),
                    new FillingTreeMap(treeMap)
            );

            uIInterface.startCreateCollectionOrMap(MAPS_TAG,
                    Integer.parseInt(fragmentMBinding.etOperationNumber.getText().toString()),
                    Integer.parseInt(fragmentMBinding.etThreadsNumber.getText().toString()),
                    listOfMaps);
        });
    }

    @Override
    public void setProgressBarVisibility() {
        for (int i = 0; i <= fragmentMBinding.grdMap.getChildCount(); i++) {
            if (fragmentMBinding.grdMap.getChildAt(i) instanceof TextWithPB) {
                ((TextWithPB) fragmentMBinding.grdMap.getChildAt(i)).setPBVisibility(true);
            }
        }
    }

    @Override
    public void postSingleOperationResult(DefOperationTags operationTag, String result) {
        ((TextWithPB) fragmentMBinding.grdMap
                .findViewWithTag(operationTag)).setResult(widgets_texts.get(operationTag) + result + MS);
    }

    @Override
    public void postBatchOperationResults(HashMap<DefOperationTags, String> resultsMap) {
        for (int i = 0; i <= fragmentMBinding.grdMap.getChildCount(); i++) {
            if (fragmentMBinding.grdMap.getChildAt(i) instanceof TextWithPB) {
                if (!resultsMap.containsKey(fragmentMBinding.grdMap.getChildAt(i).getTag())) {
                    ((TextWithPB) fragmentMBinding.grdMap.getChildAt(i)).setPBVisibility(true);
                } else {
                    ((TextWithPB) fragmentMBinding.grdMap.getChildAt(i))
                            .setResult(widgets_texts.get(fragmentMBinding.grdMap.getChildAt(i).getTag())
                                    + resultsMap.get(fragmentMBinding.grdMap.getChildAt(i).getTag()) + MS);
                }
            }
        }
    }

    @Override
    public void onDestroyView() {
        fragmentMBinding = null;
        super.onDestroyView();
    }
}