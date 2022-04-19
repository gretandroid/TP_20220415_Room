package com.example.tp_20220415_room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.tp_20220415_room.database.AppDataBase;
import com.example.tp_20220415_room.database.PersonDAO;
import com.example.tp_20220415_room.database.PersonEntity;
import com.example.tp_20220415_room.database.TestData;
import com.example.tp_20220415_room.viewmodel.MainViewModel;
import com.google.android.material.tabs.TabLayout;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<PersonEntity> arrayAdapter;
    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
