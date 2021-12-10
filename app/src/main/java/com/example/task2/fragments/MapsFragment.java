package com.example.task2.fragments;

import android.content.Context;
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

import com.example.task2.MainActivity;
import com.example.task2.databinding.FragmentMapBinding;
import com.example.task2.view_models.MapsFragmentViewModel;

import java.util.concurrent.ExecutionException;

public class MapsFragment extends Fragment {
    private FragmentMapBinding fragmentMBinding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentMBinding = FragmentMapBinding.inflate(getLayoutInflater());
        return fragmentMBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}