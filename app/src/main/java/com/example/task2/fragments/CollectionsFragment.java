package com.example.task2.fragments;

import static com.example.task2.fragments.NonUIFragment.arrayList;
import static com.example.task2.fragments.NonUIFragment.copyOnWriteArrayList;
import static com.example.task2.fragments.NonUIFragment.linkedList;
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

import com.example.task2.databinding.FragmentCollectionsBinding;
import com.example.task2.view_models.main_operations.CreateLists;
import com.example.task2.view_models.operations_with_lists.*;


import java.util.Arrays;
import java.util.List;

public class CollectionsFragment extends Fragment {
    private FragmentCollectionsBinding fragmentCBinding;
    UIToActivityInterface uIInterface;
    private List<CreateLists> innerListOfClasses;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        innerListOfClasses = Arrays.asList(
                new AddToStartList(arrayList),
                new AddToStartList(linkedList),
                new AddToStartList(copyOnWriteArrayList),
                new AddToMiddleList(arrayList),
                new AddToMiddleList(linkedList),
                new AddToMiddleList(copyOnWriteArrayList),
                new AddToEndList(arrayList),
                new AddToEndList(linkedList),
                new AddToEndList(copyOnWriteArrayList),
                new SearchInList(arrayList),
                new SearchInList(linkedList),
                new SearchInList(copyOnWriteArrayList),
                new RemoveStartList(arrayList),
                new RemoveStartList(linkedList),
                new RemoveStartList(copyOnWriteArrayList),
                new RemoveMiddleList(arrayList),
                new RemoveMiddleList(linkedList),
                new RemoveMiddleList(copyOnWriteArrayList),
                new RemoveEndList(arrayList),
                new RemoveEndList(linkedList),
                new RemoveEndList(copyOnWriteArrayList)
        );
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

        return fragmentCBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fragmentCBinding.btnStartCollections.setOnClickListener(view1 -> {
            workingWithPBUI();
            int collectionSize;
            if (fragmentCBinding.etOperationNumber.getText().toString().equals("")) {
                collectionSize = 100000;
                Toast.makeText(getContext(), "Default Collection Size = 100000", Toast.LENGTH_SHORT).show();
            } else {
                collectionSize = Integer.parseInt(fragmentCBinding.etOperationNumber.getText().toString());
            }
            uIInterface.passDataFromUI(innerListOfClasses, collectionSize);
        });
    }

    private void workingWithPBUI() {
        fragmentCBinding.tvAddToStartArraylist.setPBVisibility(true);
        fragmentCBinding.tvAddToMiddleArraylist.setPBVisibility(true);
        fragmentCBinding.tvAddToEndArraylist.setPBVisibility(true);
        fragmentCBinding.tvAddToStartLinkedlist.setPBVisibility(true);
        fragmentCBinding.tvAddToMiddleLinkedlist.setPBVisibility(true);
        fragmentCBinding.tvAddToEndLinkedlist.setPBVisibility(true);
        fragmentCBinding.tvAddToStartCowArraylist.setPBVisibility(true);
        fragmentCBinding.tvAddToMiddleCowArraylist.setPBVisibility(true);
        fragmentCBinding.tvAddToEndCowArraylist.setPBVisibility(true);
        fragmentCBinding.tvSearchArraylist.setPBVisibility(true);
        fragmentCBinding.tvSearchLinkedlist.setPBVisibility(true);
        fragmentCBinding.tvSearchCowArraylist.setPBVisibility(true);
        fragmentCBinding.tvRemoveStartArraylist.setPBVisibility(true);
        fragmentCBinding.tvRemoveStartLinkedlist.setPBVisibility(true);
        fragmentCBinding.tvRemoveStartCowArraylist.setPBVisibility(true);
        fragmentCBinding.tvRemoveMiddleArraylist.setPBVisibility(true);
        fragmentCBinding.tvRemoveMiddleLinkedlist.setPBVisibility(true);
        fragmentCBinding.tvRemoveMiddleCowArraylist.setPBVisibility(true);
        fragmentCBinding.tvRemoveEndArraylist.setPBVisibility(true);
        fragmentCBinding.tvRemoveEndLinkedlist.setPBVisibility(true);
        fragmentCBinding.tvRemoveEndCowArraylist.setPBVisibility(true);
    }

    public void setTextViewResults(int key, String value) {
        switch (key) {
            case ADD_TO_START_ARRAYLIST:
                fragmentCBinding.tvAddToStartArraylist.setText(value);
                fragmentCBinding.tvAddToStartArraylist.setPBVisibility(false);
                break;
            case ADD_TO_MIDDLE_ARRAYLIST:
                fragmentCBinding.tvAddToMiddleArraylist.setText(value);
                fragmentCBinding.tvAddToMiddleArraylist.setPBVisibility(false);
                break;
            case ADD_TO_END_ARRAYLIST:
                fragmentCBinding.tvAddToEndArraylist.setText(value);
                fragmentCBinding.tvAddToEndArraylist.setPBVisibility(false);
                break;
            case ADD_TO_START_LINKEDLIST:
                fragmentCBinding.tvAddToStartLinkedlist.setText(value);
                fragmentCBinding.tvAddToStartLinkedlist.setPBVisibility(false);
                break;
            case ADD_TO_MIDDLE_LINKEDLIST:
                fragmentCBinding.tvAddToMiddleLinkedlist.setText(value);
                fragmentCBinding.tvAddToMiddleLinkedlist.setPBVisibility(false);
                break;
            case ADD_TO_END_LINKEDLIST:
                fragmentCBinding.tvAddToEndLinkedlist.setText(value);
                fragmentCBinding.tvAddToEndLinkedlist.setPBVisibility(false);
                break;
            case ADD_TO_START_COW_ARRAYLIST:
                fragmentCBinding.tvAddToStartCowArraylist.setText(value);
                fragmentCBinding.tvAddToStartCowArraylist.setPBVisibility(false);
                break;
            case ADD_TO_MIDDLE_COW_ARRAYLIST:
                fragmentCBinding.tvAddToMiddleCowArraylist.setText(value);
                fragmentCBinding.tvAddToMiddleCowArraylist.setPBVisibility(false);
                break;
            case ADD_TO_END_COW_ARRAYLIST:
                fragmentCBinding.tvAddToEndCowArraylist.setText(value);
                fragmentCBinding.tvAddToEndCowArraylist.setPBVisibility(false);
                break;
            case SEARCH_IN_ARRAYLIST:
                fragmentCBinding.tvSearchArraylist.setText(value);
                fragmentCBinding.tvSearchArraylist.setPBVisibility(false);
                break;
            case SEARCH_IN_LINKEDLIST:
                fragmentCBinding.tvSearchLinkedlist.setText(value);
                fragmentCBinding.tvSearchLinkedlist.setPBVisibility(false);
                break;
            case SEARCH_IN_COW_ARRAYLIST:
                fragmentCBinding.tvSearchCowArraylist.setText(value);
                fragmentCBinding.tvSearchCowArraylist.setPBVisibility(false);
                break;
            case REMOVE_BEGIN_ARRAYLIST:
                fragmentCBinding.tvRemoveStartArraylist.setText(value);
                fragmentCBinding.tvRemoveStartArraylist.setPBVisibility(false);
                break;
            case REMOVE_MIDDLE_ARRAYLIST:
                fragmentCBinding.tvRemoveMiddleArraylist.setText(value);
                fragmentCBinding.tvRemoveMiddleArraylist.setPBVisibility(false);
                break;
            case REMOVE_END_ARRAYLIST:
                fragmentCBinding.tvRemoveEndArraylist.setText(value);
                fragmentCBinding.tvRemoveEndArraylist.setPBVisibility(false);
                break;
            case REMOVE_BEGIN_LINKEDLIST:
                fragmentCBinding.tvRemoveStartLinkedlist.setText(value);
                fragmentCBinding.tvRemoveStartLinkedlist.setPBVisibility(false);
                break;
            case REMOVE_MIDDLE_LINKEDLIST:
                fragmentCBinding.tvRemoveMiddleLinkedlist.setText(value);
                fragmentCBinding.tvRemoveMiddleLinkedlist.setPBVisibility(false);
                break;
            case REMOVE_END_LINKEDLIST:
                fragmentCBinding.tvRemoveEndLinkedlist.setText(value);
                fragmentCBinding.tvRemoveEndLinkedlist.setPBVisibility(false);
                break;
            case REMOVE_BEGIN_COW_ARRAYLIST:
                fragmentCBinding.tvRemoveStartCowArraylist.setText(value);
                fragmentCBinding.tvRemoveStartCowArraylist.setPBVisibility(false);
                break;
            case REMOVE_MIDDLE_COW_ARRAYLIST:
                fragmentCBinding.tvRemoveMiddleCowArraylist.setText(value);
                fragmentCBinding.tvRemoveMiddleCowArraylist.setPBVisibility(false);
                break;
            case REMOVE_END_COW_ARRAYLIST:
                fragmentCBinding.tvRemoveEndCowArraylist.setText(value);
                fragmentCBinding.tvRemoveEndCowArraylist.setPBVisibility(false);
                break;
            default:
                Log.i("test4", "something wrong with ui: key = " + key + " value = " + value);
                break;
        }
    }
}








