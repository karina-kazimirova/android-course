package com.example.sve.data.entity;

/**
 * Created by Sve on 16.08.2017.
 */

public class PersonData implements DataModel {


    public String name;
    public String surName;
    public String photo_Link;

    // ArrayList<Person> persons = new ArrayList<>();

    public PersonData(String name, String surName, String photo_Link) {
        this.name = name;
        this.surName =surName;
        this.photo_Link = photo_Link;
    }

}