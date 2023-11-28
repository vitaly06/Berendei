package ru.talisman.hackaton.models;

public class Book {
    private String dateStart, dateEnd;
    private String peopleCount, kidsCount;
    private String place, name, surname, email, number;

    public Book(String dateStart, String dateEnd, String peopleCount, String kidsCount, String place, String name, String surname, String email, String number) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.peopleCount = peopleCount;
        this.kidsCount = kidsCount;
        this.place = place;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.number = number;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(String peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getKidsCount() {
        return kidsCount;
    }

    public void setKidsCount(String kidsCount) {
        this.kidsCount = kidsCount;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getInfo(){
        return place + "; Дата заезда: " + dateStart + "; Дата выезда: " + dateEnd;
    }
}
