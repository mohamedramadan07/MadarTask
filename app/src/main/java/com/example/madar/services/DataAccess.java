package com.example.madar.services;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.madar.data.SavedData;

import java.util.List;

@Dao
public interface DataAccess {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertData(SavedData savedData);

    @Query("DELETE FROM SavedData")
    void deleteAll();

    @Query("SELECT * from SavedData")
    LiveData<List<SavedData>> selectAll();
}
