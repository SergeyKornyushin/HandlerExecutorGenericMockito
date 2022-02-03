package com.example.task2;

import static com.example.task2.NonUIFragmentPassAndSaveResultTest.DefOperandTags.OPERAND_TEST_TAG;
import static com.example.task2.NonUIFragmentPassAndSaveResultTest.DefOperationTags.OPERATION_TEST_TAG;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import com.example.task2.interfaces.NonUIToActivityInterface;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class NonUIFragmentPassAndSaveResultTest {

    private static final String RESULT = "0";

    public enum DefOperandTags {
        OPERAND_TEST_TAG
    }

    public enum DefOperationTags {
        OPERATION_TEST_TAG
    }

    private final Map<DefOperandTags, HashMap<DefOperationTags, String>> allResultsMap
            = spy(new HashMap<>());

    private final NonUIToActivityInterface nonUIInterface = mock(NonUIToActivityInterface.class);

    private void passAndSaveResultEmulation(DefOperandTags operandTag,
                                            DefOperationTags operationTag, String result) {
        if (!allResultsMap.containsKey(operandTag)) {
            allResultsMap.put(operandTag, new HashMap<DefOperationTags, String>() {{
                put(operationTag, result);
            }});
        } else {
            Objects.requireNonNull(allResultsMap.get(operandTag)).put(operationTag, result);
        }
        nonUIInterface.passDataFromNonUIToUIFragment(any(), any(), anyString());
    }

    @Test
    public void test_NonUIFragment_passAndSaveResult_method_notContainedOperand() {
        allResultsMap.clear();
        passAndSaveResultEmulation(OPERAND_TEST_TAG, OPERATION_TEST_TAG, RESULT);

        verify(allResultsMap).containsKey(OPERAND_TEST_TAG);
        verify(allResultsMap).put(OPERAND_TEST_TAG, new HashMap<DefOperationTags, String>() {{
            put(OPERATION_TEST_TAG, RESULT);
        }});

        verify(nonUIInterface).passDataFromNonUIToUIFragment(any(), any(), anyString());
    }

    @Test
    public void test_NonUIFragment_passAndSaveResult_method_containedOperand() {
        allResultsMap.clear();
        HashMap<DefOperationTags, String> innerMap = mock(HashMap.class);
        allResultsMap.put(OPERAND_TEST_TAG, innerMap);

        passAndSaveResultEmulation(OPERAND_TEST_TAG, OPERATION_TEST_TAG, RESULT);

        verify(allResultsMap).containsKey(OPERAND_TEST_TAG);
        verify(allResultsMap, never()).put(OPERAND_TEST_TAG, new HashMap<DefOperationTags, String>() {{
            put(OPERATION_TEST_TAG, RESULT);
        }});
        verify(allResultsMap).get(OPERAND_TEST_TAG);
        verify(innerMap).put(OPERATION_TEST_TAG, RESULT);

        verify(nonUIInterface).passDataFromNonUIToUIFragment(any(), any(), anyString());
    }
}
