package com.example.task2;

import static com.example.task2.VariableStorage.DefOperandTags.*;
import static com.example.task2.VariableStorage.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.task2.fragment_adapter.FragmentAdapter;
import com.example.task2.databinding.ActivityMainBinding;
import com.example.task2.fragments.CollectionsFragment;
import com.example.task2.fragments.MapsFragment;
import com.example.task2.fragments.NonUIFragment;
import com.example.task2.interfaces.NonUIToActivityInterface;
import com.example.task2.interfaces.UIToActivityInterface;
import com.example.task2.operations.main_operations.FillingGeneral;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements UIToActivityInterface, NonUIToActivityInterface {
    private NonUIFragment nonUIFragment;
    private CollectionsFragment collectionsFragment;
    private MapsFragment mapsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        collectionsFragment = new CollectionsFragment();
        mapsFragment = new MapsFragment();

        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), getLifecycle());
        activityMainBinding.vPager.setAdapter(fragmentAdapter);

        fragmentAdapter.setCollectionsFragment(collectionsFragment);
        fragmentAdapter.setMapsFragment(mapsFragment);

        String[] tabs = {"Collections", "Maps"};
        new TabLayoutMediator(activityMainBinding.tabLayout, activityMainBinding.vPager,
                (tab, position) -> tab.setText(tabs[position])
        ).attach();

        //----------<implement NonUIFragment>------------
        nonUIFragment = (NonUIFragment) getSupportFragmentManager().findFragmentByTag("work");

        if (nonUIFragment == null) {
            nonUIFragment = new NonUIFragment();
            getSupportFragmentManager().beginTransaction().add(nonUIFragment, "work").commit();
        }
        //---------->implement NonUIFragment<------------
        setFragmentFromViewPager2();
    }

    @Override
    public void startCreateCollectionOrMap(DefOperandTags operandTag,
                                           int operandSize,
                                           int numberOfThreads,
                                           List<FillingGeneral> listCollectionsOrMaps) {
        nonUIFragment.fillingOperand(operandTag, operandSize,
                numberOfThreads, listCollectionsOrMaps);
    }

    @Override
    public void requestResultsForUI(DefOperandTags operandTag) {
        nonUIFragment.getResultsForUI(operandTag);
    }

    @Override
    public void passResultsMapToUI(DefOperandTags fragmentTag, HashMap<DefOperationTags, String> resultsMap) {
        if (fragmentTag.equals(COLLECTIONS_TAG)) {
            collectionsFragment.postBatchOperationResults(resultsMap);
        } else {
            mapsFragment.postBatchOperationResults(resultsMap);
        }
    }

    @Override
    public void passDataFromNonUIToUIFragment(DefOperandTags fragmentTag,
                                              DefOperationTags operationTag, String result) {
        if (fragmentTag.equals(COLLECTIONS_TAG)) {
            collectionsFragment.postSingleOperationResult(operationTag, result);
        } else {
            mapsFragment.postSingleOperationResult(operationTag, result);
        }
    }

    private void setFragmentFromViewPager2() {
        if (getSupportFragmentManager().getFragments().size() > 1) {
            for (int i = 1; i < getSupportFragmentManager().getFragments().size(); i++) {
                if (getSupportFragmentManager().getFragments().get(i) instanceof CollectionsFragment) {
                    collectionsFragment = (CollectionsFragment) getSupportFragmentManager()
                            .getFragments().get(i);
                } else if (getSupportFragmentManager().getFragments().get(i) instanceof MapsFragment) {
                    mapsFragment = (MapsFragment) getSupportFragmentManager()
                            .getFragments().get(i);
                }
            }
        }
    }
}