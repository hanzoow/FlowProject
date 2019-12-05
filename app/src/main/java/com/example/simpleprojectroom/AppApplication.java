package com.example.simpleprojectroom;

import android.app.Application;

import androidx.room.Room;

import com.example.simpleprojectroom.Models.PersonDatabase;

public class AppApplication extends Application {
    public static PersonDatabase roomDatabase;

    private static AppApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        init(this);
    }

    private static void init(AppApplication appApplication) {
        sInstance = appApplication;
    }

    public static AppApplication getInstance() {
        return sInstance;
    }

}
