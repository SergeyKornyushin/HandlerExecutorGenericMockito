package com.example.task2;

import static com.example.task2.VariableStorage.DefOperationTags.*;

import org.junit.Test;

import static org.mockito.Mockito.*;

import android.os.Handler;

import com.example.task2.operations.main_operations.*;
import com.example.task2.operations.operations_with_lists.*;
import com.example.task2.operations.operations_with_maps.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class NonUIFragmentOperationsTest {
    private static final String ADDED_ELEMENT = "123";
    private final Handler mockHandler = mock(Handler.class);
    private final MyExecutor myExecutor = spy(new MyExecutor());

    @Test
    public void test_NonUIFragment_startOperations_method_with_mockAnyList() {
        List<String> anyList = mock(List.class);
        List<Operation> listWithMockListOperations = Arrays.asList(
                spy(new AddToStartList(anyList, TAG_FOR_TESTS)),
                spy(new AddToMiddleList(anyList, TAG_FOR_TESTS)),
                spy(new AddToEndList(anyList, TAG_FOR_TESTS)),
                spy(new SearchInList(anyList, TAG_FOR_TESTS)),
                spy(new RemoveStartList(anyList, TAG_FOR_TESTS)),
                spy(new RemoveMiddleList(anyList, TAG_FOR_TESTS)),
                spy(new RemoveEndList(anyList, TAG_FOR_TESTS))
        );

        for (Operation item : listWithMockListOperations) {
            item.handler = mockHandler;
            myExecutor.execute(item);
            verify(item).run();
            verify(item).calculate(anyList);
            verify(item).operation(anyList);
        }
        verify(anyList, times(2)).add(0, ADDED_ELEMENT);
        verify(anyList).add(-3, ADDED_ELEMENT);
        verify(anyList, times(2)).remove(0);
        verify(anyList).remove(-3);
        verify(anyList).contains(ADDED_ELEMENT);

        verify(myExecutor, times(listWithMockListOperations.size())).execute(any());
    }

    @Test
    public void test_NonUIFragment_startOperations_method_with_spyAnyList() {
        List<String> anyList = spy(new ArrayList<>());
        int arrayListSize = 10;
        for (int i = 0; i < arrayListSize; i++){
            anyList.add(i, "");
        }
        List<Operation> listWithMockListOperations = Arrays.asList(
                spy(new AddToStartList(anyList, TAG_FOR_TESTS)),
                spy(new AddToMiddleList(anyList, TAG_FOR_TESTS)),
                spy(new AddToEndList(anyList, TAG_FOR_TESTS)),
                spy(new SearchInList(anyList, TAG_FOR_TESTS)),
                spy(new RemoveStartList(anyList, TAG_FOR_TESTS)),
                spy(new RemoveMiddleList(anyList, TAG_FOR_TESTS)),
                spy(new RemoveEndList(anyList, TAG_FOR_TESTS))
        );
        for (Operation item : listWithMockListOperations) {
            item.handler = mockHandler;
            myExecutor.execute(item);
            verify(item).run();
            verify(item).calculate(anyList);
            verify(item).operation(anyList);
        }

        verify(anyList).add(0, ADDED_ELEMENT);
        verify(anyList).add(arrayListSize/2, ADDED_ELEMENT);
        verify(anyList).add(arrayListSize-1, ADDED_ELEMENT);
        verify(anyList).remove(0);
        verify(anyList).remove(arrayListSize/2+1);
        verify(anyList).remove(arrayListSize-2);
        verify(anyList).contains(ADDED_ELEMENT);

        verify(myExecutor, times(listWithMockListOperations.size())).execute(any());
    }

    @Test
    public void test_NonUIFragment_startOperations_with_mockAnyMap() {
        Map<Integer, String> anyMap = mock(Map.class);

        List<Operation> listWithMockOperation = Arrays.asList(
                spy(new AddToMap(anyMap, TAG_FOR_TESTS)),
                spy(new RemoveFromMap(anyMap, TAG_FOR_TESTS)),
                spy(new SearchInMap(anyMap, TAG_FOR_TESTS))
        );

        for (Operation item : listWithMockOperation) {
            item.handler = mockHandler;
            myExecutor.execute(item);
            verify(item).run();
            verify(item).calculate(anyMap);
            verify(item).operation(anyMap);
        }

        verify(anyMap).put(0, ADDED_ELEMENT);
        verify(anyMap).remove(123);
        verify(anyMap).containsValue(ADDED_ELEMENT);

        verify(myExecutor, times(listWithMockOperation.size())).execute(any());
    }

    @Test
    public void test_NonUIFragment_fillingOperand_with_mockLists() {
        int fillingSize = 30;
        ArrayList<String> arrayList = mock(ArrayList.class);
        LinkedList<String> linkedList = mock(LinkedList.class);
        CopyOnWriteArrayList<String> cowArraylist = mock(CopyOnWriteArrayList.class);

        List<FillingGeneral> listOfMockCollections = Arrays.asList(
                spy(new FillingArrayList(arrayList)),
                spy(new FillingLinkedList(linkedList)),
                spy(new FillingCOWArrayList(cowArraylist))
        );

        for (FillingGeneral item : listOfMockCollections) {
            item.handler = mockHandler;
            item.size = fillingSize;
            myExecutor.execute(item);
            verify(item).run();
        }
        verify(arrayList, times(fillingSize)).add(anyString());
        verify(linkedList, times(fillingSize)).add(anyString());
        verify(cowArraylist, times(fillingSize)).add(anyString());

        verify(myExecutor, times(listOfMockCollections.size())).execute(any());
    }

    @Test
    public void test_NonUIFragment_fillingOperand_with_mockMaps() {
        int fillingSize = 30;
        HashMap<Integer, String> hashMap = mock(HashMap.class);
        TreeMap<Integer, String> treeMap = mock(TreeMap.class);

        List<FillingGeneral> listOfMockMaps = Arrays.asList(
                spy(new FillingHashMap(hashMap)),
                spy(new FillingTreeMap(treeMap))
        );

        for (FillingGeneral item : listOfMockMaps) {
            item.handler = mockHandler;
            item.size = fillingSize;
            myExecutor.execute(item);
            verify(item).run();
        }
        verify(hashMap, times(fillingSize)).put(anyInt(),anyString());
        verify(treeMap, times(fillingSize)).put(anyInt(),anyString());

        verify(myExecutor, times(listOfMockMaps.size())).execute(any());
    }
}