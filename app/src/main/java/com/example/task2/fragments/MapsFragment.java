package com.example.task2.fragments;

import static com.example.task2.VariableStorage.*;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.task2.customView.TextWithPB;
import com.example.task2.databinding.FragmentMapBinding;
import com.example.task2.interfaces.FragmentsGeneralMethodsInterface;
import com.example.task2.interfaces.UIToActivityInterface;
import com.example.task2.operations.main_operations.*;
import com.example.task2.operations.operations_with_maps.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapsFragment extends Fragment
        implements FragmentsGeneralMethodsInterface {
    public static HashMap<Integer, String> hashMap = new HashMap<>();
    public static TreeMap<Integer, String> treeMap = new TreeMap<>();
    private FragmentMapBinding fragmentMBinding;
    private UIToActivityInterface uIInterface;
    private List<Operation> listReadyOperations;
    private List<FillingCollectionsAndMaps> listOfMaps;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listOfMaps = Arrays.asList(
                new FillingCollectionsAndMaps(hashMap),
                new FillingCollectionsAndMaps(treeMap)
        );
    }

    @Override
    public void getCollectionOrMap(Object map) {
        listReadyOperations = Arrays.asList(
                new AddToMap((Map) map),
                new SearchInMap((Map) map),
                new RemoveFromMap((Map) map)
        );
        uIInterface.passListOperationsFromUI(listReadyOperations);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        uIInterface = (UIToActivityInterface) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
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
    public void postSingleOperationResult(int widgetTag, String value) {
        ((TextWithPB) fragmentMBinding.grdMap
                .findViewWithTag(widgetTag)).setResult(value);
    }

    @Override
    public void postBatchOperationResults(HashMap<Integer, String> resultsMap) {
        for (int i = 0; i <= fragmentMBinding.grdMap.getChildCount(); i++) {
            if (fragmentMBinding.grdMap.getChildAt(i) instanceof TextWithPB) {
                if (!resultsMap.containsKey(fragmentMBinding.grdMap.getChildAt(i).getTag())) {
                    ((TextWithPB) fragmentMBinding.grdMap.getChildAt(i)).setPBVisibility(true);
                } else {
                    ((TextWithPB) fragmentMBinding.grdMap.getChildAt(i))
                            .setResult(resultsMap.get(fragmentMBinding.grdMap.getChildAt(i).getTag()));
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