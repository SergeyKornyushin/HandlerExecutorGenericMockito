package com.example.task2.view_models;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LiveDataVariablesViewModel extends ViewModel {

    public static MutableLiveData<String> addToStartListResult = new MutableLiveData<>();
    public static MutableLiveData<String> addToMiddleListResult = new MutableLiveData<>();
    public static MutableLiveData<String> addToEndListResult = new MutableLiveData<>();
    public static MutableLiveData<String> searchInListResult = new MutableLiveData<>();
    public static MutableLiveData<String> removeStartListResult = new MutableLiveData<>();
    public static MutableLiveData<String> removeMiddleListResult = new MutableLiveData<>();
    public static MutableLiveData<String> removeEndListResult = new MutableLiveData<>();
}
