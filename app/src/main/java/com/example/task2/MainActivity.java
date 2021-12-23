package com.example.task2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.task2.adapter.FragmentAdapter;
import com.example.task2.databinding.ActivityMainBinding;
import com.example.task2.fragments.CollectionsFragment;
import com.example.task2.fragments.MapsFragment;
import com.example.task2.fragments.NonUIFragment;
import com.example.task2.fragments.NonUIToActivityInterface;
import com.example.task2.fragments.UIToActivityInterface;
import com.example.task2.view_models.main_operations.CreateLists;
import com.google.android.material.tabs.TabLayoutMediator;

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
    public void passDataFromUI(List list, int collectionSize) {
        try {
            if (list.size() == 6) {
                nonUIFragment.startMapsOp(list, collectionSize);
            } else {
                nonUIFragment.startCollectionsOp(list, collectionSize);
            }
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void passDataFromNonUIToCollectionFragment(int key, String value) {
        collectionsFragment.setTextViewResults(key, value);
    }

    @Override
    public void passDataFromNonUIToMapsFragment(int key, String value) {
        mapsFragment.setTextViewResults(key, value);
    }
}