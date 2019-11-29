package com.example.simpleprojectroom.Models;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.simpleprojectroom.Models.PersonDao;
import com.example.simpleprojectroom.Models.entity.Person;

@Database(entities = {Person.class},version = 1)
public abstract class PersonDatabase extends RoomDatabase {

        public abstract PersonDao personDao();
}
