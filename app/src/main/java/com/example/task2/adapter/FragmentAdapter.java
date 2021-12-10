package com.example.task2.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.task2.fragments.CollectionsFragment;
import com.example.task2.fragments.IMainActivity;
import com.example.task2.fragments.MapsFragment;

public class FragmentAdapter extends FragmentStateAdapter implements IMainActivity {
    CollectionsFragment collectionsFragment;

    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        if (position == 1) {
            return new MapsFragment();
        } else return new CollectionsFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public void passData(String key, String value) {
        collectionsFragment.passData(key, value);
    }
}
