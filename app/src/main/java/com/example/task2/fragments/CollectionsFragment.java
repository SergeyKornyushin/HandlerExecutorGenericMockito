package com.example.task2.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.task2.databinding.FragmentCollectionsBinding;
import com.example.task2.view_models.CollectionsFragmentViewModel;

import java.util.concurrent.ExecutionException;

public class CollectionsFragment extends Fragment {
    private FragmentCollectionsBinding fragmentCBinding;
    private CollectionsFragmentViewModel collectionsViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentCBinding = FragmentCollectionsBinding.inflate(getLayoutInflater());
        return fragmentCBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        collectionsViewModel = new ViewModelProvider(this).get(CollectionsFragmentViewModel.class);

        collectionsViewModel.addToStartArraylistResult.observe(getViewLifecycleOwner(), s -> fragmentCBinding.tvAddToStartArraylist.setText(s));
        collectionsViewModel.addToStartArraylistProgress.observe(getViewLifecycleOwner(), integer -> {
            if (collectionsViewModel.addToStartArraylistProgress.getValue() == 0){
                fragmentCBinding.pbAddToStartArraylist.setVisibility(View.VISIBLE);
                fragmentCBinding.tvAddToStartArraylist.setVisibility(View.INVISIBLE);
            } else {
                fragmentCBinding.pbAddToStartArraylist.setVisibility(View.INVISIBLE);
                fragmentCBinding.tvAddToStartArraylist.setVisibility(View.VISIBLE);
            }
        });

        collectionsViewModel.addToMiddleArraylistResult.observe(getViewLifecycleOwner(), s -> fragmentCBinding.tvAddToMiddleArraylist.setText(s));
        collectionsViewModel.addToMiddleArraylistProgress.observe(getViewLifecycleOwner(), integer -> {
            if (collectionsViewModel.addToMiddleArraylistProgress.getValue() == 0){
                fragmentCBinding.pbAddToMiddleArraylist.setVisibility(View.VISIBLE);
                fragmentCBinding.tvAddToMiddleArraylist.setVisibility(View.INVISIBLE);
            } else {
                fragmentCBinding.pbAddToMiddleArraylist.setVisibility(View.INVISIBLE);
                fragmentCBinding.tvAddToMiddleArraylist.setVisibility(View.VISIBLE);
            }
        });

        collectionsViewModel.addToEndArraylistResult.observe(getViewLifecycleOwner(), s -> fragmentCBinding.tvAddToEndArraylist.setText(s));
        collectionsViewModel.addToEndArraylistProgress.observe(getViewLifecycleOwner(), integer -> {
            if (collectionsViewModel.addToEndArraylistProgress.getValue() == 0){
                fragmentCBinding.pbAddToEndArraylist.setVisibility(View.VISIBLE);
                fragmentCBinding.tvAddToEndArraylist.setVisibility(View.INVISIBLE);
            } else {
                fragmentCBinding.pbAddToEndArraylist.setVisibility(View.INVISIBLE);
                fragmentCBinding.tvAddToEndArraylist.setVisibility(View.VISIBLE);
            }
        });

        collectionsViewModel.searchInArraylistResult.observe(getViewLifecycleOwner(), s -> fragmentCBinding.tvSearchArraylist.setText(s));
        collectionsViewModel.searchInArraylistProgress.observe(getViewLifecycleOwner(), integer -> {
            if (collectionsViewModel.searchInArraylistProgress.getValue() == 0){
                fragmentCBinding.pbSearchArraylist.setVisibility(View.VISIBLE);
                fragmentCBinding.tvSearchArraylist.setVisibility(View.INVISIBLE);
            } else {
                fragmentCBinding.pbSearchArraylist.setVisibility(View.INVISIBLE);
                fragmentCBinding.tvSearchArraylist.setVisibility(View.VISIBLE);
            }
        });

        collectionsViewModel.removeStartArraylistResult.observe(getViewLifecycleOwner(), s -> fragmentCBinding.tvRemoveStartArraylist.setText(s));
        collectionsViewModel.removeStartArraylistProgress.observe(getViewLifecycleOwner(), integer -> {
            if (collectionsViewModel.removeStartArraylistProgress.getValue() == 0){
                fragmentCBinding.pbRemoveStartArraylist.setVisibility(View.VISIBLE);
                fragmentCBinding.tvRemoveStartArraylist.setVisibility(View.INVISIBLE);
            } else {
                fragmentCBinding.pbRemoveStartArraylist.setVisibility(View.INVISIBLE);
                fragmentCBinding.tvRemoveStartArraylist.setVisibility(View.VISIBLE);
            }
        });

        collectionsViewModel.removeMiddleArraylistResult.observe(getViewLifecycleOwner(), s -> fragmentCBinding.tvRemoveMiddleArraylist.setText(s));
        collectionsViewModel.removeMiddleArraylistProgress.observe(getViewLifecycleOwner(), integer -> {
            if (collectionsViewModel.removeMiddleArraylistProgress.getValue() == 0){
                fragmentCBinding.pbRemoveMiddleArraylist.setVisibility(View.VISIBLE);
                fragmentCBinding.tvRemoveMiddleArraylist.setVisibility(View.INVISIBLE);
            } else {
                fragmentCBinding.pbRemoveMiddleArraylist.setVisibility(View.INVISIBLE);
                fragmentCBinding.tvRemoveMiddleArraylist.setVisibility(View.VISIBLE);
            }
        });

        collectionsViewModel.removeEndArraylistResult.observe(getViewLifecycleOwner(), s -> fragmentCBinding.tvRemoveEndArraylist.setText(s));
        collectionsViewModel.removeEndArraylistProgress.observe(getViewLifecycleOwner(), integer -> {
            if (collectionsViewModel.removeEndArraylistProgress.getValue() == 0){
                fragmentCBinding.pbRemoveEndArraylist.setVisibility(View.VISIBLE);
                fragmentCBinding.tvRemoveEndArraylist.setVisibility(View.INVISIBLE);
            } else {
                fragmentCBinding.pbRemoveEndArraylist.setVisibility(View.INVISIBLE);
                fragmentCBinding.tvRemoveEndArraylist.setVisibility(View.VISIBLE);
            }
        });

        fragmentCBinding.btnStartCollections.setOnClickListener(view1 -> {
                    try {
                        collectionsViewModel.startThreads();
                    } catch (ExecutionException | InterruptedException e) {
                        e.printStackTrace();
                    }

        });
    }
}





















