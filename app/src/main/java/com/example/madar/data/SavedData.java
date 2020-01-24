package com.example.madar.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "SavedData")
public class SavedData implements Serializable {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "age")
    private int age;
    @ColumnInfo(name = "jobTitle")
    private String jobTitle;
    @ColumnInfo(name = "gender")
    private String gender;

    public SavedData(String name , int age , String jobTitle , String gender) {
        this.name = name;
        this.age = age;
        this.jobTitle = jobTitle;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getGender() {
        return gender;
    }
}
