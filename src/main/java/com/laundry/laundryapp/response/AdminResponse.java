package com.laundry.laundryapp.response;

public class AdminResponse {

    private String adminUser;
    private String adminUserName;
    private  String adminUserEmail;

    public AdminResponse() {
    }

    public AdminResponse(String adminUser, String adminUserName, String adminUserEmail) {
        this.adminUser = adminUser;
        this.adminUserName = adminUserName;
        this.adminUserEmail = adminUserEmail;
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

    @Override
    public String toString() {
        return "Admin{" +
                "adminUser='" + adminUser + '\'' +
                ", adminUserName='" + adminUserName + '\'' +
                ", adminUserEmail='" + adminUserEmail + '\'' +
                '}';
    }
}
