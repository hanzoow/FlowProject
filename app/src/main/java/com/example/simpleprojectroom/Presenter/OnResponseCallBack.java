package com.example.simpleprojectroom.Presenter;

import com.example.simpleprojectroom.Models.entity.Person;

import java.util.List;

public interface OnResponseCallBack {
    void onResponse(List<Person> people);

    void onError(String errMsg);
}
