package com.example.madar.services;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.madar.data.SavedData;

import java.util.List;

class SavedDataRepository {

    private DataAccess mDao;
    private LiveData<List<SavedData>> mAllData;

    SavedDataRepository(Application application) {
        SavedDataDB db = SavedDataDB.getDatabase(application);
        mDao = db.dataDao();
        mAllData = mDao.selectAll();
    }

    LiveData<List<SavedData>> getmAllData() {
        return mAllData;
    }

    void insert(SavedData savedData) {
        SavedDataDB.databaseWriteExecutor.execute(() -> {
            mDao.insertData(savedData);
        });
    }
}
