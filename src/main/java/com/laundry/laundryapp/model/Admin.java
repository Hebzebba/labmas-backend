package com.laundry.laundryapp.model;

public class Admin {

    private String adminUser;
    private String adminUserName;
    private  String adminUserEmail;
    private String adminPassword;

    public Admin() {
    }

    public Admin(String adminUser, String adminUserName, String adminUserEmail, String adminPassword) {
        this.adminUser = adminUser;
        this.adminUserName = adminUserName;
        this.adminUserEmail = adminUserEmail;
        this.adminPassword = adminPassword;
    }

    public String getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(String adminUser) {
        this.adminUser = adminUser;
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

    @Override
    public String toString() {
        return "Admin{" +
                "adminUser='" + adminUser + '\'' +
                ", adminUserName='" + adminUserName + '\'' +
                ", adminUserEmail='" + adminUserEmail + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                '}';
    }
}
