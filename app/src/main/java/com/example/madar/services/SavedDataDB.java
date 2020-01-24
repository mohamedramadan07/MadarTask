package com.example.madar.services;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.madar.data.SavedData;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {SavedData.class}, version = 1, exportSchema = false)
public abstract class SavedDataDB extends RoomDatabase {

    public abstract DataAccess dataDao();

    private static volatile SavedDataDB INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static SavedDataDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (SavedDataDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            SavedDataDB.class, "SavedData")
                            .addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            databaseWriteExecutor.execute(() -> {
                DataAccess dao = INSTANCE.dataDao();
                dao.deleteAll();

                SavedData savedData = new SavedData("Mohamed",23,"Developer","Male");
                dao.insertData(savedData);
            });
        }
    };
}
