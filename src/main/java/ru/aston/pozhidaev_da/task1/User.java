package ru.aston.pozhidaev_da.task1;

public class User {
    private String name;
    private int age;
    private String surname;

    public User(int age, String name, String surname) {
        this.age = age;
        this.name = name;
        this.surname = surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getSurname() {
        return surname;
    }
}
