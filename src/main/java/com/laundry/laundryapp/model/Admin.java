package com.laundry.laundryapp.model;

public class Admin {
    private String adminUserName;
    private  String adminUserEmail;
    private  String contact;
    private String adminPassword;
    private Boolean isAdmin;

    public Admin() {
    }

    public Admin(String adminUserName, String adminUserEmail, String contact, String adminPassword, Boolean isAdmin) {
        this.adminUserName = adminUserName;
        this.adminUserEmail = adminUserEmail;
        this.contact = contact;
        this.adminPassword = adminPassword;
        this.isAdmin = isAdmin;
    }

    public String getAdminUserName() {
        return adminUserName;
    }

    public void setAdminUserName(String adminUserName) {
        this.adminUserName = adminUserName;
    }

    public String getAdminUserEmail() {
        return adminUserEmail;
    }

    public void setAdminUserEmail(String adminUserEmail) {
        this.adminUserEmail = adminUserEmail;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminUserName='" + adminUserName + '\'' +
                ", adminUserEmail='" + adminUserEmail + '\'' +
                ", contact='" + contact + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
