package com.example.task2.interfaces;

import java.util.HashMap;

public interface NonUIToActivityInterface {
    void passDataFromNonUIToUIFragment(String fragmentTag, int widgetTag, String value);
    void passInfoAboutFilling(Object collectionOrMap);
    void passResultsMapToUI(String fragmentTag, HashMap<Integer, String> resultsMap);
}