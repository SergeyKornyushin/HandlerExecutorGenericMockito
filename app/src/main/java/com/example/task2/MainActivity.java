package com.example.task2;

import static com.example.task2.VariableStorage.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;

import com.example.task2.fragment_adapter.FragmentAdapter;
import com.example.task2.databinding.ActivityMainBinding;
import com.example.task2.fragments.CollectionsFragment;
import com.example.task2.fragments.MapsFragment;
import com.example.task2.fragments.NonUIFragment;
import com.example.task2.interfaces.NonUIToActivityInterface;
import com.example.task2.interfaces.UIToActivityInterface;
import com.example.task2.operations.main_operations.FillingCollectionsAndMaps;
import com.example.task2.operations.main_operations.Operation;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements UIToActivityInterface, NonUIToActivityInterface {
    private ActivityMainBinding activityMainBinding;
    private FragmentAdapter fragmentAdapter;
    private NonUIFragment nonUIFragment;
    private CollectionsFragment collectionsFragment;
    private MapsFragment mapsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        collectionsFragment = new CollectionsFragment();
        mapsFragment = new MapsFragment();

        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), getLifecycle());
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
    public void passListOperationsFromUI(List<Operation> list) {
        nonUIFragment.startOperations(list);
    }

    @Override
    public void startCreateCollectionOrMap(String collectionOrMapTag,
                                           int collectionSize,
                                           int numberOfThreads,
                                           List<FillingCollectionsAndMaps> listCollectionsOrMaps) {
        nonUIFragment.createCollectionsAndMaps(collectionOrMapTag, collectionSize,
                numberOfThreads, listCollectionsOrMaps);
    }

    @Override
    public void requestResultsForUI(String collectionOrMap) {
        nonUIFragment.getResultsForUI(collectionOrMap);
    }

    @Override
    public void passResultsMapToUI(String fragmentTag, HashMap<Integer, String> resultsMap) {
        if (fragmentTag == COLLECTIONS_TAG) {
            collectionsFragment.postBatchOperationResults(resultsMap);
        } else {
            mapsFragment.postBatchOperationResults(resultsMap);
        }
    }

    @Override
    public void passDataFromNonUIToUIFragment(String fragmentTag, int widgetTag, String value) {
        if (fragmentTag == COLLECTIONS_TAG) {
            collectionsFragment.postSingleOperationResult(widgetTag, value);
        } else {
            mapsFragment.postSingleOperationResult(widgetTag, value);
        }
    }

    @Override
    public void passInfoAboutFilling(Object listOrMap) {
        if (listOrMap instanceof List) {
            collectionsFragment.getCollectionOrMap(listOrMap);
        } else {
            mapsFragment.getCollectionOrMap(listOrMap);
        }
    }

    public void setFragmentFromViewPager2() {
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