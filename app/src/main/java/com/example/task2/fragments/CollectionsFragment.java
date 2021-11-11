package com.example.task2.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.task2.Operations;
import com.example.task2.databinding.FragmentCollectionsBinding;

import java.util.concurrent.ExecutionException;

public class CollectionsFragment extends Fragment {
    FragmentCollectionsBinding fragmentCBinding;
    private Handler mainHandler = new Handler(Looper.getMainLooper());
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentCBinding = FragmentCollectionsBinding.inflate(getLayoutInflater());

        fragmentCBinding.btnStartCollections.setOnClickListener(view -> {
//            Thread thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
                    try {
                        Operations.myThreads();
                    } catch (ExecutionException | InterruptedException e) {
                        e.printStackTrace();
                    }
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            fragmentCBinding.tvAddToStartArraylist.setText(Operations.addToStartArraylistResult);
                            fragmentCBinding.tvAddToMiddleArraylist.setText(Operations.addToMiddleArraylistResult);
                            fragmentCBinding.tvAddToEndArraylist.setText(Operations.addToEndArraylistResult);
                        }
//                    });
//                }
            });
        });

     return fragmentCBinding.getRoot();
    }
}