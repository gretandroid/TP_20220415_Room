package com.example.tp_20220415_room;

import android.content.Context;

import androidx.room.Room;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.tp_20220415_room.database.AppDataBase;
import com.example.tp_20220415_room.database.PersonDAO;
import com.example.tp_20220415_room.database.PersonEntity;
import com.example.tp_20220415_room.database.TestData;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class DatabaseTest {


    private AppDataBase database;
    private PersonDAO personDAO;
    private PersonEntity personEntity;

    @Before
    public void createDb() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        database = Room.inMemoryDatabaseBuilder(appContext, AppDataBase.class).build();
        personDAO = database.personDAO();
    }

    // S'éxecute après chaque test
    @After
    public void closeDb() {

    }

    // Execution d'un seul test
    @Test
    public void insertAllPersons() {
        personDAO.insertAll(TestData.getAll());
        int count = personDAO.getCount();
        Assert.assertEquals(4, count);
    }

    @Test
    public void deleteAllPersons() {
        personDAO.deleteAll();
        int count = personDAO.getCount();
        Assert.assertEquals(0, count);

    }
}
