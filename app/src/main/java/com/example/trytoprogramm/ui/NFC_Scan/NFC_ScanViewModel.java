package com.example.trytoprogramm.ui.NFC_Scan;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NFC_ScanViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public NFC_ScanViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is NFC_Scan fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}