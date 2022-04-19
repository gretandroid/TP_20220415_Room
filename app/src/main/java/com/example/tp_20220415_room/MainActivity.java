package com.example.tp_20220415_room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.tp_20220415_room.database.AppDataBase;
import com.example.tp_20220415_room.database.PersonDAO;
import com.example.tp_20220415_room.database.TestData;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Executor executor = Executors.newSingleThreadExecutor();
        AppDataBase appDataBase = AppDataBase.getInstance(this);
        PersonDAO personDAO = appDataBase.personDAO();
        executor.execute(() -> personDAO.insertAll(TestData.getAll()));
        executor.execute(() -> {
            Log.d("Main personDAo getAll", personDAO.getAllList().toString());
        });
        //personDAO.insertAll(TestData.getAll());



    }
}
