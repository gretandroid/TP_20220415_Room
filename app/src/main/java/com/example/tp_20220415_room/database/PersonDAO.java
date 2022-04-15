package com.example.tp_20220415_room.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public class PersonDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPerson(PersonEntity personEntity) {

    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<PersonEntity> persons) {

    }

    @Delete
    void deletePersonne(PersonEntity personEntity) {

    }


    @Query("SELECT * FROM persons WHERE id=:id")
    PersonEntity getPersonById(int id);

    @Query("SELECT * FROM persons ORDER BY date DESC")
    LiveData<List<PersonEntity>> getAll() {
        return null;
    }

    @Query("DELETE FROM persons")
    int deleteAll() {
        return 0;
    }

    @Query("SELECT COUNT (*) FROM persons")
    int getCount() {
        return 0;
    }
}
