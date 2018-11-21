package com.example.puza.nepmed.model;

public class LatestActivityItems {

    private int latestActivityImage1;
    private String latestActivityName;
    private String latestActivityNumber;
    private int latestActivityImage2;
    private String latestActivityTime;

    public LatestActivityItems(int latestActivityImage1, String latestActivityName, String latestActivityNumber, int latestActivityImage2, String latestActivityTime) {
        this.latestActivityImage1 = latestActivityImage1;
        this.latestActivityName = latestActivityName;
        this.latestActivityNumber = latestActivityNumber;
        this.latestActivityImage2 = latestActivityImage2;
        this.latestActivityTime = latestActivityTime;
    }

    public int getLatestActivityImage1() {
        return latestActivityImage1;
    }

    public void setLatestActivityImage1(int latestActivityImage1) {
        this.latestActivityImage1 = latestActivityImage1;
    }

    public String getLatestActivityName() {
        return latestActivityName;
    }

    public void setLatestActivityName(String latestActivityName) {
        this.latestActivityName = latestActivityName;
    }

    public String getLatestActivityNumber() {
        return latestActivityNumber;
    }

    public void setLatestActivityNumber(String latestActivityNumber) {
        this.latestActivityNumber = latestActivityNumber;
    }

    public int getLatestActivityImage2() {
        return latestActivityImage2;
    }

    public void setLatestActivityImage2(int latestActivityImage2) {
        this.latestActivityImage2 = latestActivityImage2;
    }

    public String getLatestActivityTime() {
        return latestActivityTime;
    }

    public void setLatestActivityTime(String latestActivityTime) {
        this.latestActivityTime = latestActivityTime;
    }
}
