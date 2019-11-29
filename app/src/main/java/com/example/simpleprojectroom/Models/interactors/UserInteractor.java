package com.example.simpleprojectroom.Models.interactors;

import com.example.simpleprojectroom.Models.entity.Person;
import com.example.simpleprojectroom.Models.interactors.impl.UserInteractorImpl;

public interface UserInteractor {
    void insertPerson(Person person, UserInteractorImpl.AddPersonCallBack callBack);
    void loadPerson(UserInteractorImpl.loadPersonCallback callBack);
}

