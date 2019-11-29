package com.example.simpleprojectroom.Models;

import com.example.simpleprojectroom.Models.entity.Person;

import java.util.List;

public interface AddPersonListener {
    void onAddSuccess(List<Person> people);
}
