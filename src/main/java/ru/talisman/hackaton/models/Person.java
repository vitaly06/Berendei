package ru.talisman.hackaton.models;

public class Person {
    private String name;
    private String email;
    private String password;
    private String secondpassword;

    public Person(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecondpassword() {
        return secondpassword;
    }

    public void setSecondpassword(String secondpassword) {
        this.secondpassword = secondpassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
