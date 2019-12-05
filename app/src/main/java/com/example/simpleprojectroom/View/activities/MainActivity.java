package com.example.simpleprojectroom.View.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.simpleprojectroom.Interface.PersonAdapterClickListener;
import com.example.simpleprojectroom.Models.PersonDatabase;
import com.example.simpleprojectroom.Models.entity.Person;
import com.example.simpleprojectroom.Presenter.SwipeIml;
import com.example.simpleprojectroom.Presenter.impl.SwipePresenter;
import com.example.simpleprojectroom.R;
import com.example.simpleprojectroom.View.LoadPersonView;
import com.example.simpleprojectroom.View.adapter.PersonAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

//import com.example.simpleprojectroom.Interface.PersonAdapterLongClickToDelete;


public class MainActivity extends AppCompatActivity implements PersonAdapter.onLoadMoreListener, PersonAdapterClickListener, LoadPersonView {
   private RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    PersonAdapter myAdapter;
    //  RecyclerView.Adapter adapter;
    SwipeRefreshLayout swipeRefreshLayout;
    private SwipeIml presenter;
    FloatingActionButton fab;
    ImageView imDelete;
    List<Person> people;
//todo private



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        presenter = new SwipePresenter(MainActivity.this, new SwipePresenter.loadPersonCallBack() {
//            @Override
//            public void onSuccess() {
//
//            }
//
//            @Override
//            public void onFail() {
//
//            }
//        });

        recyclerView = findViewById(R.id.rvUser);
        fab = findViewById(R.id.flAddUser);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateNewPersonActivity.startActivity(MainActivity.this);
            }
        });
//        SwipeController swipeController = new SwipeController();
//
//        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeController);
//        itemTouchHelper.attachToRecyclerView(recyclerView);

        //todo move to model
        PersonDatabase db = Room.databaseBuilder(getApplicationContext(), PersonDatabase.class, "person")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

        List<Person> persons = db.personDao().getAllPersons();
        // recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new PersonAdapter(this, persons, this);
        //  adapter = new PersonAdapter(this,persons);
        recyclerView.setAdapter(myAdapter);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.progressBar);
        swipeRefreshLayout.setOnRefreshListener(listener);
        swipeRefreshLayout.setColorSchemeColors(
                ContextCompat.getColor(this, R.color.colorPrimary),
                ContextCompat.getColor(this, R.color.colorAccent),
                ContextCompat.getColor(this, android.R.color.holo_green_light)
        );

    }
//
//    public void removeItem(int position) {
//        PersonDatabase db = Room.databaseBuilder(getApplicationContext(), PersonDatabase.class, "person")
//                .allowMainThreadQueries()
//                .build();
//        db.personDao().deletePerson(position);
//        myAdapter.notifyItemRemoved(position);
//    }


    private final SwipeRefreshLayout.OnRefreshListener listener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            presenter.loadPersonList(new SwipePresenter.LoadPersonCallBack() {
                @Override
                public void onSuccess(List<Person> persons) {
                    myAdapter.updatePeopleData(persons);
                }

                @Override
                public void onFail() {

                }
            });
        }
    };

    @Override
    public void onLoadMore() {
        PersonDatabase db = Room.databaseBuilder(getApplicationContext(), PersonDatabase.class, "person")
                .allowMainThreadQueries()
                .build();

        final List<Person> persons = db.personDao().getAllPersons();

        if (persons != null) {
            recyclerView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    myAdapter.updatePeopleData(persons);
                }
            }, 2000);
        }
    }

//
//    @Override
//    public void onDeleteClick(final int position) {
//        imDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                removeItem(position);
//            }
//        });
//    }


    @Override
    public void onPersonClick(Person person) {
        PersonDatabase db = Room.databaseBuilder(getApplicationContext(), PersonDatabase.class, "person")
                .allowMainThreadQueries()
                .build();
        List<Person> persons = db.personDao().getAllPersons();
//        int size = persons1.size();
//        for (int i = 0; i < size ; i++) {
//            String[] nameArray = db.personDao().getAllName();
//            if(nameArray[i].equals(db.personDao().getAllName())){
        Toast.makeText(this, "Name: " + person.getName(), Toast.LENGTH_LONG).show();
//                break;
//            }
//        }
//
    }

    @Override
    public void onDeleteClick(int position) {

    }


    @Override
    public void showProgress() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showPersonList(List<Person> people) {
        if (!people.isEmpty()) {
            myAdapter.setList(people);
        }
    }
}
