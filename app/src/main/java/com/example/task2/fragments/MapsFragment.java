package com.example.task2.fragments;

import static com.example.task2.fragments.NonUIFragment.hashMap;
import static com.example.task2.fragments.NonUIFragment.treeMap;

import static com.example.task2.view_models.VariableStorage.*;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.task2.customView.TextWithPB;
import com.example.task2.databinding.FragmentMapBinding;
import com.example.task2.view_models.main_operations.Operation;
import com.example.task2.view_models.operations_with_lists.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class MapsFragment extends Fragment {
    private FragmentMapBinding fragmentMBinding;
    private UIToActivityInterface uIInterface;
    private List<Operation> listReadyOperations;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void getMap(int tag) {
        Map tempMap;
        if (tag == TREEMAP_IS_READY) {
            tempMap = treeMap;
        } else {
            tempMap = hashMap;
        }
        listReadyOperations = Arrays.asList(
                new AddToMap(tempMap),
                new SearchInMap(tempMap),
                new RemoveFromMap(tempMap)
        );
        try {
            uIInterface.passListOperationsFromUI(listReadyOperations);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
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
            workingWithPBUI();
            if (fragmentMBinding.etThreadsNumber.getText().toString().equals("")) {
                fragmentMBinding.etThreadsNumber.setText(DEFAULT_NUMBER_OF_THREADS);
            }
            if (fragmentMBinding.etOperationNumber.getText().toString().equals("")) {
                fragmentMBinding.etOperationNumber.setText(DEFAULT_COLLECTION_SIZE);
            }
            try {
                uIInterface.startCreateCollectionOrMap(MAPS_TAG,
                        Integer.parseInt(fragmentMBinding.etOperationNumber.getText().toString()),
                        Integer.parseInt(fragmentMBinding.etThreadsNumber.getText().toString()));
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private void workingWithPBUI() {
        for (int i = 0; i <= fragmentMBinding.grdMap.getChildCount(); i++) {
            if (fragmentMBinding.grdMap.getChildAt(i) instanceof TextWithPB) {
                ((TextWithPB) fragmentMBinding.grdMap.getChildAt(i)).setPBVisibility(true);
            }
        }
    }

    public void setTextViewResults(int widgetTag, String value) {
        ((TextWithPB) fragmentMBinding.grdMap
                .findViewWithTag(widgetTag)).setResult(value);
    }

    public void setTextFromMap(HashMap<Integer, String> resultsMap) {
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















