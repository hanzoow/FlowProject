package com.example.simpleprojectroom.Models;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.simpleprojectroom.AppApplication;
import com.example.simpleprojectroom.Models.PersonDao;
import com.example.simpleprojectroom.Models.entity.Person;

@Database(entities = {Person.class},version = 1)
public abstract class PersonDatabase extends RoomDatabase {

        public abstract PersonDao personDao();
        private static PersonDatabase sInstance;
        public static PersonDatabase getInstance(){
                if(sInstance == null){
                        sInstance = Room.databaseBuilder(AppApplication.getInstance(),PersonDatabase.class,"person.fb").build();
                }
                return sInstance;
        }
}
