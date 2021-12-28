package com.example.task2.fragments;

import java.util.HashMap;

public interface NonUIToActivityInterface {
    void passDataFromNonUIToUIFragment(int fragmentTag, int widgetTag, String value);
    void passInfoAboutFilling(int tag);
    void passResultsMapToUI(int fragmentTag, HashMap<Integer, String> resultsMap);
}
