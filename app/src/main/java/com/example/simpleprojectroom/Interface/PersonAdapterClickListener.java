package com.example.simpleprojectroom.Interface;

import com.example.simpleprojectroom.Models.entity.Person;

public interface PersonAdapterClickListener {
    void onPersonClick(Person person);
    void onDeleteClick(int position);
}
