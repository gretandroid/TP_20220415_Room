package com.example.tp_20220415_room.database;

import java.util.Date;
import java.util.Objects;

public class PersonEntity {
    private int id;
    private Date date;
    private String nom;


    public PersonEntity() {
    }

    public PersonEntity(int id, Date date, String nom) {
        this.id = id;
        this.date = date;
        this.nom = nom;
    }


    public PersonEntity(Date date, String nom) {
        this.date = date;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date
                                date) {
        this.date = date;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String text) {
        this.nom = text;
    }

    @Override
    public String toString() {
        return "NoteEntity{" +
                "id=" + id +
                ", date=" + date +
                ", text='" + nom + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonEntity that = (PersonEntity) o;
        return id == that.id && Objects.equals(date, that.date) && Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, nom);
    }
}
