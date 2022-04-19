package com.example.tp_20220415_room.database;


import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// Dans cette classe on va communiquer avec la base de données
// Lorsque c'est appelé, c'est obligatoirement un Singleton
public class AppRepository {

    private static AppRepository instance;
    public LiveData<List<PersonEntity>> mPersons;
    private AppDataBase database;
    private Executor executor = Executors.newSingleThreadExecutor();

    public AppRepository(Context context) {
        database = AppDataBase.getInstance(context);
        mPersons = getAllPersons();
    }

    public static AppRepository getInstance(Context context) {
        if (instance == null) {
            instance = new AppRepository(context);
        }
        return instance;
    }

    private LiveData<List<PersonEntity>> getAllPersons() {
        return database.personDAO().getAll();
    }

    public void addAllPersons(List<PersonEntity> persons) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                database.personDAO().insertAll(persons);
            }
        });
    }

    public void deleteAllPersons() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                database.personDAO().deleteAll();
            }
        });
    }
}
