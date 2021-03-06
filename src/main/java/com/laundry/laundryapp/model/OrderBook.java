package com.laundry.laundryapp.model;

public class OrderBook {
    private String user_name;
    private String date;
    private String laundryType;
    private String telephoneNumber;
    private String email;
    private boolean status;

    public OrderBook() {
    }

    public OrderBook(String user_name, String date, String laundryType, String telephoneNumber, String email, boolean status) {
        this.user_name = user_name;
        this.date = date;
        this.laundryType = laundryType;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.status = status;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderBook{" +
                "user_name='" + user_name + '\'' +
                ", date='" + date + '\'' +
                ", laundryType='" + laundryType + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                '}';
    }
}
