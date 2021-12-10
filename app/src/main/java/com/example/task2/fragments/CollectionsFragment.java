package com.example.task2.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.task2.MainActivity;
import com.example.task2.databinding.FragmentCollectionsBinding;

import java.util.concurrent.ExecutionException;

public class CollectionsFragment extends Fragment implements IMainActivity {
    private FragmentCollectionsBinding fragmentCBinding;
    private NonUIFragment nonUIFragment = new NonUIFragment();
    private MainActivity iMainActivity;
    private String mIncomingMessage = "";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = this.getArguments();
        if (bundle != null){
            mIncomingMessage = bundle.getString("321312");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentCBinding = FragmentCollectionsBinding.inflate(getLayoutInflater());

        fragmentCBinding.tvRemoveEndArraylist.setText(mIncomingMessage);

        return fragmentCBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        fragmentCBinding.btnStartCollections.setOnClickListener(view1 -> {
            workingWithPBUI();
            try {
                nonUIFragment.startThreads();
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private void workingWithPBUI() {
        fragmentCBinding.pbAddToStartArraylist.setVisibility(View.VISIBLE);
        fragmentCBinding.pbAddToMiddleArraylist.setVisibility(View.VISIBLE);
        fragmentCBinding.pbAddToEndArraylist.setVisibility(View.VISIBLE);
    }

    public void setTextViewResults(String key, String value) {
        switch (key) {
            case "AddToStartArrayList":
                fragmentCBinding.tvAddToStartArraylist.setText(value);
                fragmentCBinding.pbAddToStartArraylist.setVisibility(View.INVISIBLE);
                break;
            case "AddToMiddleArrayList":
                fragmentCBinding.tvAddToMiddleArraylist.setText(value);
                fragmentCBinding.pbAddToMiddleArraylist.setVisibility(View.INVISIBLE);
                break;
            case "AddToEndArrayList":
                fragmentCBinding.tvAddToEndArraylist.setText(value);
                fragmentCBinding.pbAddToEndArraylist.setVisibility(View.INVISIBLE);
                break;
            default:
                Log.i("test4", "something wrong with ui: key = " + key + " value = " + value);
                break;
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        iMainActivity = (MainActivity) getActivity();
    }

    @Override
    public void passData(String key, String value) {
        fragmentCBinding.tvAddToStartArraylist.setText(value);
        fragmentCBinding.pbAddToStartArraylist.setVisibility(View.INVISIBLE);
    }
}








