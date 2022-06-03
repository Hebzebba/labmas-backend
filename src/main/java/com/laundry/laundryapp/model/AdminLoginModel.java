package com.laundry.laundryapp.model;

public class AdminLoginModel {
    private String email;
    private String password;

    public AdminLoginModel() {
    }

    public AdminLoginModel(String email, String password) {
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
}
