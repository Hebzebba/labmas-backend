package com.laundry.laundryapp.response;

public class LaundryDataResponse {
    private String laundryName;
    private double longitude;
    private double latitude;
    private String info;

    public LaundryDataResponse() {
    }

    public LaundryDataResponse(String laundryName, double locationLongitude, double latitude, String info) {
        this.laundryName = laundryName;
        this.longitude = locationLongitude;
        this.latitude = latitude;
        this.info = info;
    }

    public String getLaundryName() {
        return laundryName;
    }

    public void setLaundryName(String laundryName) {
        this.laundryName = laundryName;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "LaundryDataResponse{" +
                "laundryName='" + laundryName + '\'' +
                ", locationLongitude=" + longitude +
                ", locationLatitude=" + latitude +
                ", info='" + info + '\'' +
                '}';
    }
}
