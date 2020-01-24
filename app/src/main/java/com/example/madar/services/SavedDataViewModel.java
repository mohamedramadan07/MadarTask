package com.example.madar.services;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.madar.data.SavedData;

import java.util.List;

public class SavedDataViewModel extends AndroidViewModel {

    private SavedDataRepository mRepository;

    private LiveData<List<SavedData>> mAllWords;

    public SavedDataViewModel (Application application) {
        super(application);
        mRepository = new SavedDataRepository(application);
        mAllWords = mRepository.getmAllData();
    }

    public LiveData<List<SavedData>> getAllData() { return mAllWords; }

    public void insert(SavedData savedData) { mRepository.insert(savedData); }
}