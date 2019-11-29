package com.example.simpleprojectroom.View.activities;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.simpleprojectroom.Presenter.AddPresenter;
import com.example.simpleprojectroom.Models.entity.Person;
import com.example.simpleprojectroom.Models.PersonDatabase;
import com.example.simpleprojectroom.Presenter.impl.AddPresenterImpl;
import com.example.simpleprojectroom.R;
import com.example.simpleprojectroom.View.CreateNewPersonView;
import com.example.simpleprojectroom.View.adapter.PersonAdapter;

import java.util.List;

public class CreateNewPersonActivity extends AppCompatActivity implements CreateNewPersonView {
    AddPresenter presenter;
    EditText edtName, edtSurname, edtPT;
    PersonAdapter myAdapter;
    Button btnAdd;
    List<Person> people;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_person);
        presenter = new AddPresenterImpl((CreateNewPersonView) this);
        edtName = findViewById(R.id.edtName);
        edtSurname = findViewById(R.id.edtSurName);
        edtPT = findViewById(R.id.edtPt);
        btnAdd = findViewById(R.id.btnAdd);


        final PersonDatabase db = Room.databaseBuilder(getApplicationContext(), PersonDatabase.class, "person")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(presenter.handleAdd(edtName.getText().toString().trim(),edtSurname.getText().toString().trim(),edtPT.getText().toString().trim()) == true){
//                    Person person = new Person(edtName.getText().toString().trim(),edtSurname.getText().toString().trim(),edtPT.getText().toString().trim());
//                    db.personDao().insertAll(person);
//                    // myAdapter.notifyDataSetChanged();
//                    startActivity(new Intent(CreateNewPersonActivity.this, MainActivity.class));
//                }
//                else{
//                    Log.d("d","ABC");
//                }

                String name = edtName.getText().toString().trim();
                String surName = edtSurname.getText().toString().trim();
                String pt = edtPT.getText().toString().trim();
                if (validateInput(name, surName, pt)) {
                    presenter.insertPerson(new Person(name, surName, pt), new AddPresenterImpl.AddPersonCallBack() {
                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onFail() {

                        }
                    });
                }
            }
        });

    }

    private boolean validateInput(String name, String surname, String pt) {
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(surname) || TextUtils.isEmpty(pt)) {
            Toast.makeText(this, "Fail!", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            if (!name.isEmpty() && !surname.isEmpty() && !pt.isEmpty()) {
                Toast.makeText(this, "Succes!", Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        return true;
    }
}
