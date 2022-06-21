package com.laundry.laundryapp.response;

public class AdminResponse {

    private String adminUserName;
    private  String adminUserEmail;
    private  String contact;

    public AdminResponse() {
    }

    public AdminResponse(String adminUserName, String adminUserEmail, String contact) {
        this.adminUserName = adminUserName;
        this.adminUserEmail = adminUserEmail;
        this.contact = contact;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "AdminResponse{" +
                "adminUserName='" + adminUserName + '\'' +
                ", adminUserEmail='" + adminUserEmail + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
