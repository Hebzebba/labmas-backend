package com.laundry.laundryapp.model;

public class OrderBook {
    private String user_name;
    private String date;
    private String laundryType;
    private String telephoneNumber;
    private String email;

    public OrderBook() {
    }

    public OrderBook(String user_name, String date, String laundryType, String telephoneNumber, String email) {
        this.user_name = user_name;
        this.date = date;
        this.laundryType = laundryType;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLaundryType() {
        return laundryType;
    }

    public void setLaundryType(String laundryType) {
        this.laundryType = laundryType;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "OrderBook{" +
                "name='" + user_name + '\'' +
                ", location='" + date + '\'' +
                ", laundryType='" + laundryType + '\'' +
                ", laundryType='" + telephoneNumber + '\'' +
                ", telephoneNumber=" + email +
                '}';
    }
}
