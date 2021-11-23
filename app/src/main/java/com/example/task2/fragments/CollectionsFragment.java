package com.example.task2.fragments;

import static com.example.task2.view_models.LiveDataVariablesViewModel.*;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.task2.databinding.FragmentCollectionsBinding;
import com.example.task2.view_models.ListsFragmentViewModel;
import com.example.task2.view_models.LiveDataVariablesViewModel;

import java.util.concurrent.ExecutionException;

public class CollectionsFragment extends Fragment {
    private FragmentCollectionsBinding fragmentCBinding;
    private LiveDataVariablesViewModel liveDataViewModel;
    private ListsFragmentViewModel listsFragmentViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentCBinding = FragmentCollectionsBinding.inflate(getLayoutInflater());
        return fragmentCBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        liveDataViewModel = new ViewModelProvider(this).get(LiveDataVariablesViewModel.class);
        listsFragmentViewModel = new ViewModelProvider(this).get(ListsFragmentViewModel.class);

        addToStartListResult.observe(getViewLifecycleOwner(), s -> {
            fragmentCBinding.tvAddToStartArraylist.setText(s);
            if (addToStartListResult.getValue().equals("0")) {
                fragmentCBinding.pbAddToStartArraylist.setVisibility(View.VISIBLE);
                fragmentCBinding.tvAddToStartArraylist.setVisibility(View.INVISIBLE);
            } else {
                fragmentCBinding.pbAddToStartArraylist.setVisibility(View.INVISIBLE);
                fragmentCBinding.tvAddToStartArraylist.setVisibility(View.VISIBLE);
            }
        });

        addToMiddleListResult.observe(getViewLifecycleOwner(), s -> {
            fragmentCBinding.tvAddToMiddleArraylist.setText(s);
            if (addToMiddleListResult.getValue().equals("0")) {
                fragmentCBinding.pbAddToMiddleArraylist.setVisibility(View.VISIBLE);
                fragmentCBinding.tvAddToMiddleArraylist.setVisibility(View.INVISIBLE);
            } else {
                fragmentCBinding.pbAddToMiddleArraylist.setVisibility(View.INVISIBLE);
                fragmentCBinding.tvAddToMiddleArraylist.setVisibility(View.VISIBLE);
            }
        });

        addToEndListResult.observe(getViewLifecycleOwner(), s -> fragmentCBinding.tvAddToEndArraylist.setText(s));
        searchInListResult.observe(getViewLifecycleOwner(), s -> fragmentCBinding.tvSearchArraylist.setText(s));
        removeStartListResult.observe(getViewLifecycleOwner(), s -> fragmentCBinding.tvRemoveStartArraylist.setText(s));
        removeMiddleListResult.observe(getViewLifecycleOwner(), s -> fragmentCBinding.tvRemoveMiddleArraylist.setText(s));
        removeEndListResult.observe(getViewLifecycleOwner(), s -> fragmentCBinding.tvRemoveEndArraylist.setText(s));


//        collectionsViewModel.addToStartArraylistResult.observe(getViewLifecycleOwner(), s -> fragmentCBinding.tvAddToStartArraylist.setText(s));
//        collectionsViewModel.addToStartArraylistResult.observe(getViewLifecycleOwner(), integer -> {
//            if (collectionsViewModel.addToStartArraylistResult.getValue().equals("0")) {
//                fragmentCBinding.pbAddToStartArraylist.setVisibility(View.VISIBLE);
//                fragmentCBinding.tvAddToStartArraylist.setVisibility(View.INVISIBLE);
//            } else {
//                fragmentCBinding.pbAddToStartArraylist.setVisibility(View.INVISIBLE);
//                fragmentCBinding.tvAddToStartArraylist.setVisibility(View.VISIBLE);
//            }
//        });

       /* collectionsViewModel.addToMiddleArraylistResult.observe(getViewLifecycleOwner(), s -> fragmentCBinding.tvAddToMiddleArraylist.setText(s));
        collectionsViewModel.addToMiddleArraylistResult.observe(getViewLifecycleOwner(), integer -> {
            if (collectionsViewModel.addToMiddleArraylistResult.getValue().equals("0")) {
                fragmentCBinding.pbAddToMiddleArraylist.setVisibility(View.VISIBLE);
                fragmentCBinding.tvAddToMiddleArraylist.setVisibility(View.INVISIBLE);
            } else {
                fragmentCBinding.pbAddToMiddleArraylist.setVisibility(View.INVISIBLE);
                fragmentCBinding.tvAddToMiddleArraylist.setVisibility(View.VISIBLE);
            }
        });

        collectionsViewModel.addToEndArraylistResult.observe(getViewLifecycleOwner(), s -> fragmentCBinding.tvAddToEndArraylist.setText(s));
        collectionsViewModel.addToEndArraylistResult.observe(getViewLifecycleOwner(), integer -> {
            if (collectionsViewModel.addToEndArraylistResult.getValue().equals("0")) {
                fragmentCBinding.pbAddToEndArraylist.setVisibility(View.VISIBLE);
                fragmentCBinding.tvAddToEndArraylist.setVisibility(View.INVISIBLE);
            } else {
                fragmentCBinding.pbAddToEndArraylist.setVisibility(View.INVISIBLE);
                fragmentCBinding.tvAddToEndArraylist.setVisibility(View.VISIBLE);
            }
        });

        collectionsViewModel.searchInArraylistResult.observe(getViewLifecycleOwner(), s -> fragmentCBinding.tvSearchArraylist.setText(s));
        collectionsViewModel.searchInArraylistResult.observe(getViewLifecycleOwner(), integer -> {
            if (collectionsViewModel.searchInArraylistResult.getValue().equals("0")) {
                fragmentCBinding.pbSearchArraylist.setVisibility(View.VISIBLE);
                fragmentCBinding.tvSearchArraylist.setVisibility(View.INVISIBLE);
            } else {
                fragmentCBinding.pbSearchArraylist.setVisibility(View.INVISIBLE);
                fragmentCBinding.tvSearchArraylist.setVisibility(View.VISIBLE);
            }
        });

        collectionsViewModel.removeStartArraylistResult.observe(getViewLifecycleOwner(), s -> fragmentCBinding.tvRemoveStartArraylist.setText(s));
        collectionsViewModel.removeStartArraylistResult.observe(getViewLifecycleOwner(), integer -> {
            if (collectionsViewModel.removeStartArraylistResult.getValue().equals("0")) {
                fragmentCBinding.pbRemoveStartArraylist.setVisibility(View.VISIBLE);
                fragmentCBinding.tvRemoveStartArraylist.setVisibility(View.INVISIBLE);
            } else {
                fragmentCBinding.pbRemoveStartArraylist.setVisibility(View.INVISIBLE);
                fragmentCBinding.tvRemoveStartArraylist.setVisibility(View.VISIBLE);
            }
        });

        collectionsViewModel.removeMiddleArraylistResult.observe(getViewLifecycleOwner(), s -> fragmentCBinding.tvRemoveMiddleArraylist.setText(s));
        collectionsViewModel.removeMiddleArraylistResult.observe(getViewLifecycleOwner(), integer -> {
            if (collectionsViewModel.removeMiddleArraylistResult.getValue().equals("0")) {
                fragmentCBinding.pbRemoveMiddleArraylist.setVisibility(View.VISIBLE);
                fragmentCBinding.tvRemoveMiddleArraylist.setVisibility(View.INVISIBLE);
            } else {
                fragmentCBinding.pbRemoveMiddleArraylist.setVisibility(View.INVISIBLE);
                fragmentCBinding.tvRemoveMiddleArraylist.setVisibility(View.VISIBLE);
            }
        });

        collectionsViewModel.removeEndArraylistResult.observe(getViewLifecycleOwner(), s -> fragmentCBinding.tvRemoveEndArraylist.setText(s));
        collectionsViewModel.removeEndArraylistResult.observe(getViewLifecycleOwner(), integer -> {
            if (collectionsViewModel.removeEndArraylistResult.getValue().equals("0")) {
                fragmentCBinding.pbRemoveEndArraylist.setVisibility(View.VISIBLE);
                fragmentCBinding.tvRemoveEndArraylist.setVisibility(View.INVISIBLE);
            } else {
                fragmentCBinding.pbRemoveEndArraylist.setVisibility(View.INVISIBLE);
                fragmentCBinding.tvRemoveEndArraylist.setVisibility(View.VISIBLE);
            }
        });*/

        fragmentCBinding.btnStartCollections.setOnClickListener(view1 -> {
            addToStartListResult.setValue("0");
            addToMiddleListResult.setValue("0");
            addToEndListResult.setValue("0");
            searchInListResult.setValue("0");
            removeStartListResult.setValue("0");
            removeMiddleListResult.setValue("0");
            removeEndListResult.setValue("0");
            try {
                listsFragmentViewModel.startThreads();
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }

        });
    }
}





















