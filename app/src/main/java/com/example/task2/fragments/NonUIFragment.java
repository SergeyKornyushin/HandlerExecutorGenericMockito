package com.example.task2.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.task2.MainActivity;
import com.example.task2.R;
import com.example.task2.fragments.CollectionsFragment;
import com.example.task2.view_models.operations_with_lists.*;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NonUIFragment extends Fragment {

    private ArrayList<String> arrayList = new ArrayList<>();
    private LinkedList<String> linkedList = new LinkedList<>();
    private CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
    private double collectionSize;
    private Map<String, String> resultsMap = new HashMap<>();

    private IMainActivity iMainActivity;

    private final Handler handler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 1:
                    resultsMap.put("AddToStartArrayList", msg.obj.toString());
                    iMainActivity.passData("AddToStartArrayList", msg.obj.toString());
//                    bundle.putString("AddToStartArrayList", resultsMap.get("AddToStartArrayList"));
//                    Log.i("test4", "bundle: "+bundle.get("AddToStartArrayList"));
                    break;
                case 11:
                    resultsMap.put("AddToStartLinkedList", msg.obj.toString());
                    break;
                case 21:
                    resultsMap.put("AddToStartCOWArrayList", msg.obj.toString());
                    break;
                case 2:
                    resultsMap.put("AddToMiddleArrayList", msg.obj.toString());
                    break;
                case 12:
                    resultsMap.put("AddToMiddleLinkedList", msg.obj.toString());
                    break;
                case 22:
                    resultsMap.put("AddToMiddleCOWArrayList", msg.obj.toString());
                    break;
                case 3:
                    resultsMap.put("AddToEndArrayList", msg.obj.toString());
                    break;
                case 13:
                    resultsMap.put("AddToEndLinkedList", msg.obj.toString());
                    break;
                case 23:
                    resultsMap.put("AddToEndCOWArrayList", msg.obj.toString());
                    break;
                default:
                    Log.i("test4", "not Ready solution " + msg.what);
                    break;
            }
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return null;
    }

    public void startThreads() throws ExecutionException, InterruptedException {
        collectionSize = 300000;
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(new CreateCollections(collectionSize, arrayList,
                linkedList, copyOnWriteArrayList));
        executorService.submit(new AddToStartList(arrayList, handler));
        executorService.submit(new AddToStartList(linkedList, handler));
        executorService.submit(new AddToStartList(copyOnWriteArrayList, handler));
        executorService.submit(new AddToMiddleList(arrayList, handler));
        executorService.submit(new AddToMiddleList(linkedList, handler));
        executorService.submit(new AddToMiddleList(copyOnWriteArrayList, handler));
        executorService.submit(new AddToEndList(arrayList, handler));
        executorService.submit(new AddToEndList(linkedList, handler));
        executorService.submit(new AddToEndList(copyOnWriteArrayList, handler));
//        executorService.submit(new SearchInList());
//        executorService.submit(new RemoveStartList());
//        executorService.submit(new RemoveMiddleList());
//        executorService.submit(new RemoveEndList());

        executorService.shutdown();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        iMainActivity = (IMainActivity)getActivity();
        Log.i("test4", "onAttach: ");
    }
}