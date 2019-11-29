package com.example.simpleprojectroom;

import android.app.Application;

import androidx.room.Room;

import com.example.simpleprojectroom.Models.PersonDatabase;

public class AppApplication extends Application {
    public static PersonDatabase roomDatabase;

    @Override
    public void onCreate() {
        super.onCreate();

        roomDatabase = Room.databaseBuilder(this, PersonDatabase.class, "person")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }
}
