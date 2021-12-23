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

import com.example.task2.databinding.FragmentMapBinding;
import com.example.task2.view_models.main_operations.CreateMaps;
import com.example.task2.view_models.operations_with_lists.AddToMap;
import com.example.task2.view_models.operations_with_lists.RemoveFromMap;
import com.example.task2.view_models.operations_with_lists.SearchInMap;

import java.util.Arrays;
import java.util.List;

public class MapsFragment extends Fragment {
    private FragmentMapBinding fragmentMBinding;
    UIToActivityInterface uIInterface;
    private List<CreateMaps> innerListOfClasses;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        innerListOfClasses = Arrays.asList(
                new AddToMap(hashMap),
                new AddToMap(treeMap),
                new SearchInMap(hashMap),
                new SearchInMap(treeMap),
                new RemoveFromMap(hashMap),
                new RemoveFromMap(treeMap)
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
        fragmentMBinding = FragmentMapBinding.inflate(getLayoutInflater());

        return fragmentMBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentMBinding.btnStartMaps.setOnClickListener(view1 -> {
            workingWithPBUI();
            int collectionSize;
            if (fragmentMBinding.etOperationNumber.getText().toString().equals("")) {
                collectionSize = 100000;
                Toast.makeText(getContext(), "Default Maps Size = 100000", Toast.LENGTH_SHORT).show();
            } else {
                collectionSize = Integer.parseInt(fragmentMBinding.etOperationNumber.getText().toString());
            }
            uIInterface.passDataFromUI(innerListOfClasses, collectionSize);
        });
    }

    private void workingWithPBUI() {
        fragmentMBinding.tvAddToHashMap.setPBVisibility(true);
        fragmentMBinding.tvAddToTreeMap.setPBVisibility(true);
        fragmentMBinding.tvSearchInHashMap.setPBVisibility(true);
        fragmentMBinding.tvSearchInTreeMap.setPBVisibility(true);
        fragmentMBinding.tvRemoveFromHashMap.setPBVisibility(true);
        fragmentMBinding.tvRemoveFromTreeMap.setPBVisibility(true);
    }

    public void setTextViewResults(int key, String value) {
        switch (key) {
            case ADDING_TO_HASHMAP:
                fragmentMBinding.tvAddToHashMap.setText(value);
                fragmentMBinding.tvAddToHashMap.setPBVisibility(false);
                break;
            case ADDING_TO_TREEMAP:
                fragmentMBinding.tvAddToTreeMap.setText(value);
                fragmentMBinding.tvAddToTreeMap.setPBVisibility(false);
                break;
            case SEARCH_IN_HASHMAP:
                fragmentMBinding.tvSearchInHashMap.setText(value);
                fragmentMBinding.tvSearchInHashMap.setPBVisibility(false);
                break;
            case SEARCH_IN_TREEMAP:
                fragmentMBinding.tvSearchInTreeMap.setText(value);
                fragmentMBinding.tvSearchInTreeMap.setPBVisibility(false);
                break;
            case REMOVE_FROM_HASHMAP:
                fragmentMBinding.tvRemoveFromHashMap.setText(value);
                fragmentMBinding.tvRemoveFromHashMap.setPBVisibility(false);
                break;
            case REMOVE_FROM_TREEMAP:
                fragmentMBinding.tvRemoveFromTreeMap.setText(value);
                fragmentMBinding.tvRemoveFromTreeMap.setPBVisibility(false);
                break;
            default:
                Log.i("test4", "something wrong with MAPS ui: key = " + key + " value = " + value);
                break;
        }
    }
}















