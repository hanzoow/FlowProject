package com.example.simpleprojectroom.Presenter;

import com.example.simpleprojectroom.Models.entity.Person;
import com.example.simpleprojectroom.Presenter.impl.AddPresenterImpl;

// Interface for AddPresenterImpl
public interface AddPresenter {
    void insertPerson(Person person, AddPresenterImpl.AddPersonCallBack callBack);
}
