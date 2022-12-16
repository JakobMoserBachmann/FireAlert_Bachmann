package com.example.trytoprogramm.ui.PeopleList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PeopleListViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public PeopleListViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is PeopleList fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}