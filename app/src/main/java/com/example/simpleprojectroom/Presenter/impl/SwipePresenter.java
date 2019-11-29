package com.example.simpleprojectroom.Presenter.impl;

import com.example.simpleprojectroom.Models.entity.Person;
import com.example.simpleprojectroom.Models.interactors.UserInteractor;
import com.example.simpleprojectroom.Models.interactors.impl.UserInteractorImpl;
import com.example.simpleprojectroom.Presenter.OnResponseCallBack;
import com.example.simpleprojectroom.Presenter.SwipeIml;
import com.example.simpleprojectroom.View.LoadPersonView;

import java.util.List;

public class SwipePresenter implements SwipeIml {

    private LoadPersonView view;
    private UserInteractor model;

    public SwipePresenter(LoadPersonView view,LoadPersonCallBack callback) {
        this.view = view;
        this.model = (UserInteractor) callback;
    }



    private final OnResponseCallBack callBack = new OnResponseCallBack() {
        @Override
        public void onResponse(List<Person> people) {
            view.showPersonList(people);
            view.hideProgress();
        }

        @Override
        public void onError(String errMsg) {
            view.hideProgress();
        }
    };

    @Override
    public void loadPersonList(final LoadPersonCallBack callBack) {
        view.showProgress();
        model.loadPerson(new UserInteractorImpl.loadPersonCallback() {
            @Override
            public void onSuccess(List<Person> persons) {
                callBack.onSuccess(persons);
            }

            @Override
            public void onFail() {

            }
        });
    }

    public interface LoadPersonCallBack{
        void onSuccess(List<Person> persons);
        void onFail();
    }
}
