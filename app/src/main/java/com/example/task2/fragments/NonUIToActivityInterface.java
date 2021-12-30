package com.example.task2.fragments;

import java.util.HashMap;

public interface NonUIToActivityInterface {
    void passDataFromNonUIToUIFragment(String fragmentTag, int widgetTag, String value);
    void passInfoAboutFilling(int tag);
    void passResultsMapToUI(String fragmentTag, HashMap<Integer, String> resultsMap);
}
