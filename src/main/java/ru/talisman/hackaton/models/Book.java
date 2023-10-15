package ru.talisman.hackaton.models;

public class Book {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTypePlace() {
        return typePlace;
    }

    public void setTypePlace(String typePlace) {
        this.typePlace = typePlace;
    }

    private String name;
    private String phoneNumber;
    private String typePlace;
    public Book(){

    }
    public Book(String name, String phoneNumber, String typePlace) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.typePlace = typePlace;
    }



}
