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

import com.example.task2.VariableStorage.*;
import com.example.task2.customView.TextWithPB;
import com.example.task2.databinding.FragmentCollectionsBinding;
import com.example.task2.interfaces.FragmentsGeneralMethodsInterface;
import com.example.task2.interfaces.UIToActivityInterface;
import com.example.task2.operations.main_operations.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionsFragment extends Fragment
        implements FragmentsGeneralMethodsInterface {
    private static final ArrayList<String> arrayList = new ArrayList<>();
    private static final LinkedList<String> linkedList = new LinkedList<>();
    private static final CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
    private FragmentCollectionsBinding fragmentCBinding;
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
            setProgressBarVisibility();
            if (fragmentCBinding.etThreadsNumber.getText().toString().equals("")) {
                fragmentCBinding.etThreadsNumber.setText(DEFAULT_NUMBER_OF_THREADS);
            }
            if (fragmentCBinding.etOperationNumber.getText().toString().equals("")) {
                fragmentCBinding.etOperationNumber.setText(DEFAULT_COLLECTION_SIZE);
            }
            List<FillingGeneral> listOfCollections = Arrays.asList(
                    new FillingArrayList(arrayList),
                    new FillingLinkedList(linkedList),
                    new FillingCOWArrayList(copyOnWriteArrayList)
            );

            uIInterface.startCreateCollectionOrMap(COLLECTIONS_TAG,
                    Integer.parseInt(fragmentCBinding.etOperationNumber.getText().toString()),
                    Integer.parseInt(fragmentCBinding.etThreadsNumber.getText().toString()),
                    listOfCollections);
        });
    }

    @Override
    public void setProgressBarVisibility() {
        for (int i = 0; i <= fragmentCBinding.grdCollection.getChildCount(); i++) {
            if (fragmentCBinding.grdCollection.getChildAt(i) instanceof TextWithPB) {
                ((TextWithPB) fragmentCBinding.grdCollection.getChildAt(i)).setPBVisibility(true);
            }
        }
    }

    @Override
    public void postSingleOperationResult(DefOperationTags operationTag, String result) {
        ((TextWithPB) fragmentCBinding.grdCollection
                .findViewWithTag(operationTag)).setResult(widgets_texts.get(operationTag) + result + MS);
    }

    @Override
    public void postBatchOperationResults(HashMap<DefOperationTags, String> resultsMap) {
        for (int i = 0; i <= fragmentCBinding.grdCollection.getChildCount(); i++) {
            if (fragmentCBinding.grdCollection.getChildAt(i) instanceof TextWithPB) {
                if (!resultsMap.containsKey(fragmentCBinding.grdCollection.getChildAt(i).getTag())) {
                    ((TextWithPB) fragmentCBinding.grdCollection.getChildAt(i)).setPBVisibility(true);
                } else {
                    ((TextWithPB) fragmentCBinding.grdCollection.getChildAt(i))
                            .setResult(widgets_texts.get(fragmentCBinding.grdCollection.getChildAt(i).getTag())
                                    + resultsMap.get(fragmentCBinding.grdCollection.getChildAt(i).getTag()) + MS);
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