package com.naimyag.ornek.mineline;

/**
 * Created by Naim on 4.02.2016.
 */
public class User {

    private String name;
    private String surname;
    private int id;

    public User() {
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }


    @Override
    public String toString() {
        return "User{"+
                "id="+id+
                ", name="+name+
                ", surname="+surname+
                '}';
    }



}
