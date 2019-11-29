package com.example.simpleprojectroom.View;

import com.example.simpleprojectroom.Models.entity.Person;

import java.util.List;

public interface LoadPersonView  {
    void showProgress();
    void hideProgress();
    void showPersonList(List<Person> people);
}
