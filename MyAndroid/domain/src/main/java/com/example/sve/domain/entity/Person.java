package com.example.sve.domain.entity;

/**
 * Created by Sve on 14.08.2017.
 */

public class Person {

    public String name;
    public String surName;
    public String photo_Link;

    // ArrayList<Person> persons = new ArrayList<>();

    public Person(String name, String surName, String photo_Link) {
        this.name = name;
        this.surName =surName;
        this.photo_Link = photo_Link;
    }


}
