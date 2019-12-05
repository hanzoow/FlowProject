package com.example.simpleprojectroom.Models.interactors;

import com.example.simpleprojectroom.Models.entity.Person;
import com.example.simpleprojectroom.Models.interactors.impl.UserInteractorImpl;

import java.util.List;
import java.util.Observable;

public interface UserInteractor {
    void insertPerson(Person person, UserInteractorImpl.AddPersonCallBack callBack);
//    Observable<List<Person>> loadPerson();
    void loadPerson(List<Person> person);
}

