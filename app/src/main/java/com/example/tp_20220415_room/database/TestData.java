package com.example.tp_20220415_room.database;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TestData {
    static SimpleDateFormat formatter= new SimpleDateFormat("dd/mm/yyyy", Locale.getDefault());
    static List<PersonEntity> listPersons;
    static {
        listPersons = new ArrayList<PersonEntity>();
        try {
            listPersons.add(new PersonEntity(1, formatter.parse("10/02/1991"),"Assma"));
            listPersons.add(new PersonEntity(2, formatter.parse("10/02/1971"),"Olivier"));
            listPersons.add(new PersonEntity(3, formatter.parse("10/02/1988"),"Jodré"));
            listPersons.add(new PersonEntity(4, formatter.parse("10/02/2004"),"Samy"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public static List<PersonEntity> getAll() {
        return listPersons;
    }
}
