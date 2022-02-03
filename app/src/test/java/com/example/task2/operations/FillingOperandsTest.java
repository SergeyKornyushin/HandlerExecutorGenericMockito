package com.example.task2.operations;

import static org.junit.Assert.*;

import android.widget.LinearLayout;

import com.example.task2.fragments.NonUIFragment;
import com.example.task2.operations.main_operations.FillingArrayList;
import com.example.task2.operations.main_operations.FillingCOWArrayList;
import com.example.task2.operations.main_operations.FillingHashMap;
import com.example.task2.operations.main_operations.FillingLinkedList;
import com.example.task2.operations.main_operations.FillingTreeMap;
import com.google.common.util.concurrent.MoreExecutors;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FillingOperandsTest {
    private ExecutorService executorService;
    public static final int OPERAND_SIZE = 3000;

    @Before
    public void setUp(){
        executorService = MoreExecutors.newDirectExecutorService();
    }

    @Test
    public void filling_arraylist() throws InterruptedException {
        ArrayList<String> arrayList = new ArrayList<>();
        FillingArrayList fillingArrayList = new FillingArrayList(arrayList);
        fillingArrayList.size = OPERAND_SIZE;
        executorService.submit(fillingArrayList);

        assertEquals(OPERAND_SIZE, arrayList.size());
    }

    @Test
    public void filling_linkedlist() throws InterruptedException {
        LinkedList<String> linkedList = new LinkedList<>();
        FillingLinkedList fillingLinkedList = new FillingLinkedList(linkedList);
        fillingLinkedList.size = OPERAND_SIZE;
        executorService.submit(fillingLinkedList);

        assertEquals(OPERAND_SIZE, linkedList.size());
    }

    @Test
    public void filling_cow_arraylist() throws InterruptedException {
        CopyOnWriteArrayList<String> cowArrayList = new CopyOnWriteArrayList<>();
        FillingCOWArrayList fillingCOWArrayList = new FillingCOWArrayList(cowArrayList);
        fillingCOWArrayList.size = OPERAND_SIZE;
        executorService.submit(fillingCOWArrayList);

        assertEquals(OPERAND_SIZE, cowArrayList.size());
    }

    @Test
    public void filling_hashmap() throws InterruptedException {
        HashMap<Integer, String> hashMap = new HashMap<>();
        FillingHashMap fillingHashMap = new FillingHashMap(hashMap);
        fillingHashMap.size = OPERAND_SIZE;
        executorService.submit(fillingHashMap);

        assertEquals(OPERAND_SIZE, hashMap.size());
    }

    @Test
    public void filling_treemap() throws InterruptedException {
        TreeMap<Integer, String > treeMap = new TreeMap<>();
        FillingTreeMap fillingTreeMap = new FillingTreeMap(treeMap);
        fillingTreeMap.size = OPERAND_SIZE;
        executorService.submit(fillingTreeMap);

        assertEquals(OPERAND_SIZE, treeMap.size());
    }
}