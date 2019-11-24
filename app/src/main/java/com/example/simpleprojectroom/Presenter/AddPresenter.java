package com.example.simpleprojectroom.Presenter;

import android.text.TextUtils;

import com.example.simpleprojectroom.Interface.AddView;

public class AddPresenter implements com.example.simpleprojectroom.Interface.AddPresenter {

    private AddView view;

    public AddPresenter(AddView view){
        this.view = view;
    }

    @Override
    public boolean handleAdd(String name, String surname, String pt) {
        if(TextUtils.isEmpty(name) || TextUtils.isEmpty(surname) || TextUtils.isEmpty(pt)){
            view.showValidationErrormsg();
            return false;
        }
        else{
            if(!name.isEmpty() && !surname.isEmpty() && !pt.isEmpty()){
                view.addSucces();
                return true;
            }
        }
        return true;
    }



}
