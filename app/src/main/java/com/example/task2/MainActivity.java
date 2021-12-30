package com.example.task2;

import static com.example.task2.view_models.VariableStorage.*;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.task2.adapter.FragmentAdapter;
import com.example.task2.databinding.ActivityMainBinding;
import com.example.task2.fragments.CollectionsFragment;
import com.example.task2.fragments.MapsFragment;
import com.example.task2.fragments.NonUIFragment;
import com.example.task2.fragments.NonUIToActivityInterface;
import com.example.task2.fragments.UIToActivityInterface;
import com.example.task2.view_models.main_operations.Operation;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

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
        FragmentManager fragmentManager = getSupportFragmentManager();
        nonUIFragment = (NonUIFragment) fragmentManager.findFragmentByTag("work");

        if (nonUIFragment == null) {
            nonUIFragment = new NonUIFragment();
            fragmentManager.beginTransaction().add(nonUIFragment, "work").commit();
        }
        //---------->implement NonUIFragment<------------
    }

    @Override
    public void passListOperationsFromUI(List<Operation> list) throws ExecutionException, InterruptedException {
        nonUIFragment.startOperations(list);
    }

    @Override
    public void startCreateCollectionOrMap(String collectionOrMapTag, int collectionSize, int numberOfThreads)
            throws ExecutionException, InterruptedException {
        nonUIFragment.createCollectionsAndMaps(collectionOrMapTag, collectionSize, numberOfThreads);
    }

    @Override
    public void requestResultsForUI(String collectionOrMap) {
        nonUIFragment.getResultsForUI(collectionOrMap);
    }

    @Override
    public void passResultsMapToUI(String fragmentTag, HashMap<Integer, String> resultsMap) {
        setFragmentFromViewPager();
        if (fragmentTag == COLLECTIONS_TAG) {
            collectionsFragment.setTextFromMap(resultsMap);
        } else {
            mapsFragment.setTextFromMap(resultsMap);
        }
    }

    @Override
    public void passDataFromNonUIToUIFragment(String fragmentTag, int widgetTag, String value) {
        setFragmentFromViewPager();
        if (fragmentTag == COLLECTIONS_TAG) {
            collectionsFragment.setTextViewResults(widgetTag, value);
        } else {
            mapsFragment.setTextViewResults(widgetTag, value);
        }
    }

    @Override
    public void passInfoAboutFilling(int tag) {
        switch (tag) {
            case ARRAYLIST_IS_READY:
                collectionsFragment.getCollection(ARRAYLIST_IS_READY);
                break;
            case LINKEDLIST_IS_READY:
                collectionsFragment.getCollection(LINKEDLIST_IS_READY);
                break;
            case COW_ARRAYLIST_IS_READY:
                collectionsFragment.getCollection(COW_ARRAYLIST_IS_READY);
                break;
            case HASHMAP_IS_READY:
                mapsFragment.getMap(HASHMAP_IS_READY);
                break;
            case TREEMAP_IS_READY:
                mapsFragment.getMap(TREEMAP_IS_READY);
                break;
        }
    }

    public void setFragmentFromViewPager() {
        collectionsFragment = (CollectionsFragment) getSupportFragmentManager()
                .findFragmentByTag(COLLECTIONS_TAG);
        mapsFragment = (MapsFragment) getSupportFragmentManager()
                .findFragmentByTag(MAPS_TAG);
    }
}
