package com.example.task2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.task2.adapter.FragmentAdapter;
import com.example.task2.databinding.ActivityMainBinding;
import com.example.task2.fragments.CollectionsFragment;
import com.example.task2.fragments.IMainActivity;
import com.example.task2.fragments.NonUIFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity implements IMainActivity {
    private ActivityMainBinding activityMainBinding;
    private FragmentAdapter fragmentAdapter;
    private NonUIFragment nonUIFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), getLifecycle());
        activityMainBinding.vPager.setAdapter(fragmentAdapter);

        String[] tabs = {"Collections", "Maps"};
        new TabLayoutMediator(activityMainBinding.tabLayout, activityMainBinding.vPager,
                (tab, position) -> tab.setText(tabs[position])
        ).attach();

        //----------<implement NonUIFragment>------------
        FragmentManager fragmentManager = getSupportFragmentManager();
        nonUIFragment = (NonUIFragment)fragmentManager.findFragmentByTag("work");

        if(nonUIFragment == null){
            nonUIFragment = new NonUIFragment();
            fragmentManager.beginTransaction().add(nonUIFragment, "work").commit();
        }
        //---------->implement NonUIFragment<------------
    }

    @Override
    public void passData(String key, String value) {

        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), getLifecycle());
        fragmentAdapter.passData(key, value);

//        String tag = "android:switcher:" + R.id.v_pager + ":" + 1;
//        CollectionsFragment cf = (CollectionsFragment) getSupportFragmentManager().findFragmentByTag(tag);
//        cf.setTextViewResults(key, value);
//
//        Bundle bundle = new Bundle();
//        bundle.putString(key, value);
//        CollectionsFragment collectionsFragment = new CollectionsFragment();
//        collectionsFragment.setArguments(bundle);
//        getSupportFragmentManager().beginTransaction()
//                .add(collectionsFragment, "123").commit();

    }
}