package com.Huangheng.model;

import java.util.Date;

public class User {
    private String ID;
    private String UserName;
    private String Password;
    private String Email;
    private String Gender;
    private java.util.Date Birthdate;

    public User() {
    }

    public User(String id, String userName, String password, String email, String gender, Date birthdate) {
        ID = id;
        UserName = userName;
        Password = password;
        Email = email;
        Gender = gender;
        Birthdate = birthdate;
    }

    public String getID() {
        return ID;
    }

    public void setID(String id) {
        ID = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public Date getBirthdate() {
        return Birthdate;
    }

    public void setBirthdate(Date birthdate) {
        Birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID='" + ID + '\'' +
                "UserName='" + UserName + '\'' +
                ", Password='" + Password + '\'' +
                ", Email='" + Email + '\'' +
                ", Gender='" + Gender + '\'' +
                ", Birthdate=" + Birthdate +
                '}';
    }
}
