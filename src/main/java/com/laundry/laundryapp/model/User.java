package com.laundry.laundryapp.model;

public class User {
    private String fullName;
    private String email;
    private String contact;
    private String password;

    public User() {
    }

    public User(String fullName, String email, String contact, String password) {
        this.fullName = fullName;
        this.email = email;
        this.contact = contact;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
