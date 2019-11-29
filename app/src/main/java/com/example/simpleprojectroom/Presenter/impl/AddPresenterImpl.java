package com.example.simpleprojectroom.Presenter.impl;

import com.example.simpleprojectroom.Models.entity.Person;
import com.example.simpleprojectroom.Models.interactors.UserInteractor;
import com.example.simpleprojectroom.Models.interactors.impl.UserInteractorImpl;
import com.example.simpleprojectroom.Presenter.AddPresenter;
import com.example.simpleprojectroom.View.CreateNewPersonView;

public class AddPresenterImpl implements AddPresenter {
    private CreateNewPersonView view;

    private UserInteractor userInteractor;

    public AddPresenterImpl(CreateNewPersonView view) {
        this.view = view;
        userInteractor = new UserInteractorImpl();
    }

    @Override
    public void insertPerson(Person person, final AddPersonCallBack callBack) {
        userInteractor.insertPerson(person, new UserInteractorImpl.AddPersonCallBack() {
            @Override
            public void onSuccess() {
                callBack.onSuccess();
            }

            @Override
            public void onFail() {
                callBack.onFail();
            }
        });
    }

    public interface AddPersonCallBack {
        void onSuccess();

        void onFail();
    }
}
