package com.example.task2.adapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.task2.fragments.CollectionsFragment;
import com.example.task2.fragments.MapsFragment;

public class FragmentAdapter extends FragmentStateAdapter {

    public void setMapsFragment(MapsFragment mapsFragment) {
        this.mapsFragment = mapsFragment;
    }

    public void setCollectionsFragment(CollectionsFragment collectionsFragment) {
        this.collectionsFragment = collectionsFragment;
    }

    private MapsFragment mapsFragment;
    private CollectionsFragment collectionsFragment;

    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 1) {
            return mapsFragment;
        } else {
            return collectionsFragment;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);

    }
}
