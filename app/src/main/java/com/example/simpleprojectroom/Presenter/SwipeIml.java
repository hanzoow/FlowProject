package com.example.simpleprojectroom.Presenter;

import com.example.simpleprojectroom.Models.interactors.UserInteractor;
import com.example.simpleprojectroom.Presenter.impl.SwipePresenter;

public interface SwipeIml {
    void loadPersonList(SwipePresenter.LoadPersonCallBack callBack);
}
