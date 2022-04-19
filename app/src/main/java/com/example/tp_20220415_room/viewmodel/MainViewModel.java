package com.example.tp_20220415_room.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.tp_20220415_room.database.AppRepository;
import com.example.tp_20220415_room.database.PersonEntity;

import java.util.List;

// L'objectif de cette classe est de communiquer avec le repository
// On a beosin d'un context dans le constructeur
// Pour cela on étend un AndroidViewModel

public class MainViewModel extends AndroidViewModel {

    private AppRepository mRepository;
    public LiveData<List<PersonEntity>> mPersons;

    public MainViewModel(@NonNull Application application) {
        super(application);
        mRepository = AppRepository.getInstance(application.getApplicationContext());
        mPersons = mRepository.mPersons;
    }

    public void addAllPersons(List<PersonEntity> persons) {
        mRepository.addAllPersons(persons);
    }

    public void deleteAllPersons() {
        mRepository.deleteAllPersons();
    }
}
