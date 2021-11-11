package com.example.task2.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.task2.databinding.FragmentMapBinding;

public class MapsFragment extends Fragment {
    FragmentMapBinding fragmentMBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentMBinding = FragmentMapBinding.inflate(getLayoutInflater());
        return fragmentMBinding.getRoot();
    }
}