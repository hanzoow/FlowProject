package com.example.simpleprojectroom.View;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.simpleprojectroom.Interface.AddPresenter;
import com.example.simpleprojectroom.Interface.AddView;
import com.example.simpleprojectroom.Models.Person;
import com.example.simpleprojectroom.PersonDatabase;
import com.example.simpleprojectroom.R;
import com.example.simpleprojectroom.adapter.PersonAdapter;

import java.util.List;

public class CreateNewPerson extends AppCompatActivity implements AddView {
    AddPresenter presenter;
    EditText edtName,edtSurname,edtPT;
    PersonAdapter myAdapter;
    Button btnAdd;
    List<Person> people;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_person);
        presenter = new com.example.simpleprojectroom.Presenter.AddPresenter((AddView) this);
        edtName = findViewById(R.id.edtName);
        edtSurname = findViewById(R.id.edtSurName);
        edtPT = findViewById(R.id.edtPt);
        btnAdd = findViewById(R.id.btnAdd);


        final PersonDatabase db = Room.databaseBuilder(getApplicationContext(),PersonDatabase.class,"person")
                .allowMainThreadQueries()
                .build();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(presenter.handleAdd(edtName.getText().toString().trim(),edtSurname.getText().toString().trim(),edtPT.getText().toString().trim()) == true){
                    Person person = new Person(edtName.getText().toString().trim(),edtSurname.getText().toString().trim(),edtPT.getText().toString().trim());
                    db.personDao().insertAll(person);
                    // myAdapter.notifyDataSetChanged();
                    startActivity(new Intent(CreateNewPerson.this, MainActivity.class));
                }
                else{
                    Log.d("d","ABC");
                }
            }
        });

    }

    @Override
    public void showValidationErrormsg() {
        Toast.makeText(this,"Some fields is blank!",Toast.LENGTH_LONG).show();
    }

    @Override
    public void addSucces() {
        Toast.makeText(this,"Succes!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void addFail() {
        Toast.makeText(this,"Fail!",Toast.LENGTH_SHORT).show();
    }
}
