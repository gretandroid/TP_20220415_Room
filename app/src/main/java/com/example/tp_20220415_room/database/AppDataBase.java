package com.example.tp_20220415_room.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities={PersonEntity.class}, version = 1)
@TypeConverters(DateConverter.class)
public abstract class AppDataBase extends RoomDatabase {
    public static final String DATABASE_NAME = "AppDataBase.db";

    //Cette variable est une instance de la base de données
    // qui peut être partagée par plusieurs threads, elle doit
    // toujours être en mémoire, jamais en cache
    private static volatile AppDataBase instance;

    // L'accès à l'instance doit être synchronisé
    private static final Object LOCK = new Object();

    public abstract PersonDAO personDAO();


    public static AppDataBase getInstance(Context context) {
        if(instance == null) {
            synchronized (LOCK) {
                instance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDataBase.class,
                        DATABASE_NAME).build();
            }
        }
        return instance;
    }
}
