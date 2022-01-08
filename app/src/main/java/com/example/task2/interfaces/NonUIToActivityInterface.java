package com.example.task2.interfaces;

import java.util.HashMap;

public interface NonUIToActivityInterface {
    void passDataFromNonUIToUIFragment(Integer fragmentTag, int widgetTag, String value);
    void passInfoAboutFilling(Object collectionOrMap);
    void passResultsMapToUI(Integer fragmentTag, HashMap<Integer, String> resultsMap);
}