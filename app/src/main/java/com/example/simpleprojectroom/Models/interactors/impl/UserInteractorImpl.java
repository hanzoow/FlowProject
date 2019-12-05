package com.example.simpleprojectroom.Models.interactors.impl;

import android.content.Context;

import androidx.room.Room;

import com.example.simpleprojectroom.AppApplication;
import com.example.simpleprojectroom.Models.PersonDao;
import com.example.simpleprojectroom.Models.PersonDatabase;
import com.example.simpleprojectroom.Models.entity.Person;
import com.example.simpleprojectroom.Models.interactors.UserInteractor;

import java.util.List;

public class UserInteractorImpl implements UserInteractor {
//    private PersonDatabase db ;
//    private Context context;
    private PersonDao Dao;
    public UserInteractorImpl(PersonDao personDao) {
//        db = Room.databaseBuilder(context, PersonDatabase.class, "person")
//                .fallbackToDestructiveMigration()
//                .allowMainThreadQueries()
//                .build();

    }

    @Override
    public void insertPerson(Person person, AddPersonCallBack callBack) {
        AppApplication.roomDatabase.personDao().insertAll(person);
    }

    @Override
    public void loadPerson(List<Person> person) {
        AppApplication.roomDatabase.personDao().insertAll();
    }

//    @Override
//    public void loadPerson(loadPersonCallback callBack) {
//        callBack.onSuccess(AppApplication.roomDatabase.personDao().getAllPersons());
//    }


    //xu ly tu

    public interface loadPersonCallback {
        void onSuccess(List<Person> persons);

        void onFail();
    }

    public interface AddPersonCallBack {
        void onSuccess();

        //void onLoadPersonSuccess();
        void onFail();
    }

}