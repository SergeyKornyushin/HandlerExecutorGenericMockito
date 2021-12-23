package com.example.task2.fragments;

import static com.example.task2.view_models.VariableStorage.*;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.task2.view_models.main_operations.CreateLists;
import com.example.task2.view_models.main_operations.CreateMaps;
import com.example.task2.view_models.operations_with_lists.*;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NonUIFragment extends Fragment {

    public static ArrayList<String> arrayList = new ArrayList<>();
    public static LinkedList<String> linkedList = new LinkedList<>();
    public static CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
    public static HashMap<Integer, String> hashMap = new HashMap<>();
    public static TreeMap<Integer, String> treeMap = new TreeMap<>();
    private Map<String, String> resultsMap = new HashMap<>();
    private NonUIToActivityInterface nonUIInterface;

    private final Handler handler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case ADD_TO_START_ARRAYLIST:
                    nonUIInterface.passDataFromNonUIToCollectionFragment(ADD_TO_START_ARRAYLIST,
                            add_to_start_arraylist + msg.obj.toString() + ms);
                    break;
                case ADD_TO_START_LINKEDLIST:
                    nonUIInterface.passDataFromNonUIToCollectionFragment(ADD_TO_START_LINKEDLIST,
                            add_to_start_linkedlist + msg.obj.toString() + ms);
                    break;
                case ADD_TO_START_COW_ARRAYLIST:
                    nonUIInterface.passDataFromNonUIToCollectionFragment(ADD_TO_START_COW_ARRAYLIST,
                            add_to_start_cow_arraylist + msg.obj.toString() + ms);
                    break;
                case ADD_TO_MIDDLE_ARRAYLIST:
                    nonUIInterface.passDataFromNonUIToCollectionFragment(ADD_TO_MIDDLE_ARRAYLIST,
                            add_to_middle_arraylist + msg.obj.toString() + ms);
                    break;
                case ADD_TO_MIDDLE_LINKEDLIST:
                    nonUIInterface.passDataFromNonUIToCollectionFragment(ADD_TO_MIDDLE_LINKEDLIST,
                            add_to_middle_linkedlist + msg.obj.toString() + ms);
                    break;
                case ADD_TO_MIDDLE_COW_ARRAYLIST:
                    nonUIInterface.passDataFromNonUIToCollectionFragment(ADD_TO_MIDDLE_COW_ARRAYLIST,
                            add_to_middle_cow_arraylist + msg.obj.toString() + ms);
                    break;
                case ADD_TO_END_ARRAYLIST:
                    nonUIInterface.passDataFromNonUIToCollectionFragment(ADD_TO_END_ARRAYLIST,
                            add_to_end_arraylist + msg.obj.toString() + ms);
                    break;
                case ADD_TO_END_LINKEDLIST:
                    nonUIInterface.passDataFromNonUIToCollectionFragment(ADD_TO_END_LINKEDLIST,
                            add_to_end_linkedlist + msg.obj.toString() + ms);
                    break;
                case ADD_TO_END_COW_ARRAYLIST:
                    nonUIInterface.passDataFromNonUIToCollectionFragment(ADD_TO_END_COW_ARRAYLIST,
                            add_to_end_cow_arraylist + msg.obj.toString() + ms);
                    break;
                case SEARCH_IN_ARRAYLIST:
                    nonUIInterface.passDataFromNonUIToCollectionFragment(SEARCH_IN_ARRAYLIST,
                            search_in_arraylist + msg.obj.toString() + ms);
                    break;
                case SEARCH_IN_LINKEDLIST:
                    nonUIInterface.passDataFromNonUIToCollectionFragment(SEARCH_IN_LINKEDLIST,
                            search_in_linkedlist + msg.obj.toString() + ms);
                    break;
                case SEARCH_IN_COW_ARRAYLIST:
                    nonUIInterface.passDataFromNonUIToCollectionFragment(SEARCH_IN_COW_ARRAYLIST,
                            search_in_cow_arraylist + msg.obj.toString() + ms);
                    break;
                case REMOVE_BEGIN_ARRAYLIST:
                    nonUIInterface.passDataFromNonUIToCollectionFragment(REMOVE_BEGIN_ARRAYLIST,
                            removing_from_start_arraylist + msg.obj.toString() + ms);
                    break;
                case REMOVE_BEGIN_LINKEDLIST:
                    nonUIInterface.passDataFromNonUIToCollectionFragment(REMOVE_BEGIN_LINKEDLIST,
                            removing_from_start_linkedlist + msg.obj.toString() + ms);
                    break;
                case REMOVE_BEGIN_COW_ARRAYLIST:
                    nonUIInterface.passDataFromNonUIToCollectionFragment(REMOVE_BEGIN_COW_ARRAYLIST,
                            removing_from_start_cow_arraylist + msg.obj.toString() + ms);
                    break;
                case REMOVE_MIDDLE_ARRAYLIST:
                    nonUIInterface.passDataFromNonUIToCollectionFragment(REMOVE_MIDDLE_ARRAYLIST,
                            removing_from_middle_arraylist + msg.obj.toString() + ms);
                    break;
                case REMOVE_MIDDLE_LINKEDLIST:
                    nonUIInterface.passDataFromNonUIToCollectionFragment(REMOVE_MIDDLE_LINKEDLIST,
                            removing_from_middle_linkedlist + msg.obj.toString() + ms);
                    break;
                case REMOVE_MIDDLE_COW_ARRAYLIST:
                    nonUIInterface.passDataFromNonUIToCollectionFragment(REMOVE_MIDDLE_COW_ARRAYLIST,
                            removing_from_middle_cow_arraylist + msg.obj.toString() + ms);
                    break;
                case REMOVE_END_ARRAYLIST:
                    nonUIInterface.passDataFromNonUIToCollectionFragment(REMOVE_END_ARRAYLIST,
                            removing_from_end_arraylist + msg.obj.toString() + ms);
                    break;
                case REMOVE_END_LINKEDLIST:
                    nonUIInterface.passDataFromNonUIToCollectionFragment(REMOVE_END_LINKEDLIST,
                            removing_from_end_linkedlist + msg.obj.toString() + ms);
                    break;
                case REMOVE_END_COW_ARRAYLIST:
                    nonUIInterface.passDataFromNonUIToCollectionFragment(REMOVE_END_COW_ARRAYLIST,
                            removing_from_end_cow_arraylist + msg.obj.toString() + ms);
                    break;

                case ADDING_TO_HASHMAP:
                    nonUIInterface.passDataFromNonUIToMapsFragment(ADDING_TO_HASHMAP,
                            add_to_hashmap + msg.obj.toString() + ms);
                    break;
                case ADDING_TO_TREEMAP:
                    nonUIInterface.passDataFromNonUIToMapsFragment(ADDING_TO_TREEMAP,
                            add_to_treemap + msg.obj.toString() + ms);
                    break;
                case SEARCH_IN_HASHMAP:
                    nonUIInterface.passDataFromNonUIToMapsFragment(SEARCH_IN_HASHMAP,
                            search_in_hashmap + msg.obj.toString() + ms);
                    break;
                case SEARCH_IN_TREEMAP:
                    nonUIInterface.passDataFromNonUIToMapsFragment(SEARCH_IN_TREEMAP,
                            search_in_treemap + msg.obj.toString() + ms);
                    break;
                case REMOVE_FROM_HASHMAP:
                    nonUIInterface.passDataFromNonUIToMapsFragment(REMOVE_FROM_HASHMAP,
                            removing_from_hashmap + msg.obj.toString() + ms);
                    break;
                case REMOVE_FROM_TREEMAP:
                    nonUIInterface.passDataFromNonUIToMapsFragment(REMOVE_FROM_TREEMAP,
                            removing_from_treemap + msg.obj.toString() + ms);
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


    public void startCollectionsOp(List<CreateLists> list, int collectionSize) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new CreateCollections(collectionSize));

        for (CreateLists item : list) {
            item.handler = this.handler;
            executorService.submit(item);
        }
        Log.i("test4", arrayList.size() + " " + linkedList.size() + " " + copyOnWriteArrayList.size());
        executorService.shutdown();
    }

    public void startMapsOp(List<CreateMaps> list, int collectionSize) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new CreateHashMapAndTreeMap(collectionSize));

        for (CreateMaps item : list) {
            item.handler = this.handler;
            executorService.submit(item);
        }
        Log.i("test4", hashMap.size() + " " + treeMap.size());
        executorService.shutdown();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        nonUIInterface = (NonUIToActivityInterface) getActivity();
    }
}


