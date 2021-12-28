package com.example.task2.fragments;

import static com.example.task2.fragments.NonUIFragment.arrayList;
import static com.example.task2.fragments.NonUIFragment.copyOnWriteArrayList;
import static com.example.task2.fragments.NonUIFragment.hashMap;
import static com.example.task2.fragments.NonUIFragment.linkedList;
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
import com.example.task2.databinding.FragmentCollectionsBinding;
import com.example.task2.view_models.main_operations.Operation;
import com.example.task2.view_models.operations_with_lists.*;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class CollectionsFragment extends Fragment {
    private FragmentCollectionsBinding fragmentCBinding;
    private UIToActivityInterface uIInterface;
    private List<Operation> listReadyOperations;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void getCollection(int tag) {
        List tempList;
        if (tag == ARRAYLIST_IS_READY) {
            tempList = arrayList;
        } else if (tag == LINKEDLIST_IS_READY) {
            tempList = linkedList;
        } else {
            tempList = copyOnWriteArrayList;
        }
        listReadyOperations = Arrays.asList(
                new AddToStartList(tempList),
                new AddToMiddleList(tempList),
                new AddToEndList(tempList),
                new SearchInList(tempList),
                new RemoveStartList(tempList),
                new RemoveMiddleList(tempList),
                new RemoveEndList(tempList)
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
        fragmentCBinding = FragmentCollectionsBinding.inflate(getLayoutInflater());

        fragmentCBinding.tvAddToStartArraylist.setTag(ADD_TO_START_ARRAYLIST);
        fragmentCBinding.tvAddToStartLinkedlist.setTag(ADD_TO_START_LINKEDLIST);
        fragmentCBinding.tvAddToStartCowArraylist.setTag(ADD_TO_START_COW_ARRAYLIST);
        fragmentCBinding.tvAddToMiddleArraylist.setTag(ADD_TO_MIDDLE_ARRAYLIST);
        fragmentCBinding.tvAddToMiddleLinkedlist.setTag(ADD_TO_MIDDLE_LINKEDLIST);
        fragmentCBinding.tvAddToMiddleCowArraylist.setTag(ADD_TO_MIDDLE_COW_ARRAYLIST);
        fragmentCBinding.tvAddToEndArraylist.setTag(ADD_TO_END_ARRAYLIST);
        fragmentCBinding.tvAddToEndLinkedlist.setTag(ADD_TO_END_LINKEDLIST);
        fragmentCBinding.tvAddToEndCowArraylist.setTag(ADD_TO_END_COW_ARRAYLIST);
        fragmentCBinding.tvSearchArraylist.setTag(SEARCH_IN_ARRAYLIST);
        fragmentCBinding.tvSearchLinkedlist.setTag(SEARCH_IN_LINKEDLIST);
        fragmentCBinding.tvSearchCowArraylist.setTag(SEARCH_IN_COW_ARRAYLIST);
        fragmentCBinding.tvRemoveStartArraylist.setTag(REMOVE_BEGIN_ARRAYLIST);
        fragmentCBinding.tvRemoveStartLinkedlist.setTag(REMOVE_BEGIN_LINKEDLIST);
        fragmentCBinding.tvRemoveStartCowArraylist.setTag(REMOVE_BEGIN_COW_ARRAYLIST);
        fragmentCBinding.tvRemoveMiddleArraylist.setTag(REMOVE_MIDDLE_ARRAYLIST);
        fragmentCBinding.tvRemoveMiddleLinkedlist.setTag(REMOVE_MIDDLE_LINKEDLIST);
        fragmentCBinding.tvRemoveMiddleCowArraylist.setTag(REMOVE_MIDDLE_COW_ARRAYLIST);
        fragmentCBinding.tvRemoveEndArraylist.setTag(REMOVE_END_ARRAYLIST);
        fragmentCBinding.tvRemoveEndLinkedlist.setTag(REMOVE_END_LINKEDLIST);
        fragmentCBinding.tvRemoveEndCowArraylist.setTag(REMOVE_END_COW_ARRAYLIST);

        uIInterface.requestResultsForUI(COLLECTIONS_TAG);

        return fragmentCBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentCBinding.btnStartCollections.setOnClickListener(view1 -> {
            workingWithPBUI();
            if (fragmentCBinding.etThreadsNumber.getText().toString().equals("")) {
                fragmentCBinding.etThreadsNumber.setText(DEFAULT_NUMBER_OF_THREADS);
            }
            if (fragmentCBinding.etOperationNumber.getText().toString().equals("")) {
                fragmentCBinding.etOperationNumber.setText(DEFAULT_COLLECTION_SIZE);
            }
            try {
                uIInterface.startCreateCollectionOrMap(COLLECTIONS_TAG,
                        Integer.parseInt(fragmentCBinding.etOperationNumber.getText().toString()),
                        Integer.parseInt(fragmentCBinding.etThreadsNumber.getText().toString()));
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private void workingWithPBUI() {
        for (int i = 0; i <= fragmentCBinding.grdCollection.getChildCount(); i++) {
            if (fragmentCBinding.grdCollection.getChildAt(i) instanceof TextWithPB) {
                ((TextWithPB) fragmentCBinding.grdCollection.getChildAt(i)).setPBVisibility(true);
            }
        }
    }

    public void setTextViewResults(int widgetTag, String value) {
        ((TextWithPB) fragmentCBinding.grdCollection
                .findViewWithTag(widgetTag)).setResult(value);
    }

    public void setTextFromMap(HashMap<Integer, String> resultsMap) {
        for (int i = 0; i <= fragmentCBinding.grdCollection.getChildCount(); i++) {
            if (fragmentCBinding.grdCollection.getChildAt(i) instanceof TextWithPB) {
                if (!resultsMap.containsKey(fragmentCBinding.grdCollection.getChildAt(i).getTag())) {
                    ((TextWithPB) fragmentCBinding.grdCollection.getChildAt(i)).setPBVisibility(true);
                } else {
                    ((TextWithPB) fragmentCBinding.grdCollection.getChildAt(i))
                            .setResult(resultsMap.get(fragmentCBinding.grdCollection.getChildAt(i).getTag()));
                }
            }
        }
    }

    @Override
    public void onDestroyView() {
        fragmentCBinding = null;
        super.onDestroyView();
    }
}








