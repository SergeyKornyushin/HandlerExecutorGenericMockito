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

        Log.i("test4", "main "+Thread.currentThread().getName());

        collectionsViewModel.addToStartArraylistResult.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                fragmentCBinding.tvAddToStartArraylist.setVisibility(View.VISIBLE);
                fragmentCBinding.pbAddToStartArraylist.setVisibility(View.INVISIBLE);
                fragmentCBinding.tvAddToStartArraylist.setText(s);
            }
        });

        collectionsViewModel.addToMiddleArraylistResult.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                fragmentCBinding.tvAddToMiddleArraylist.setText(s);
            }
        });

        collectionsViewModel.addToEndArraylistResult.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                fragmentCBinding.tvAddToEndArraylist.setText(s);
            }
        });

        fragmentCBinding.btnStartCollections.setOnClickListener(view1 -> {
            Log.i("test4", "after click "+Thread.currentThread().getName());
//            fragmentCBinding.tvAddToStartArraylist.setVisibility(View.INVISIBLE);
//            fragmentCBinding.pbAddToStartArraylist.setVisibility(View.VISIBLE);
            try {
                collectionsViewModel.startThreads();
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}





















