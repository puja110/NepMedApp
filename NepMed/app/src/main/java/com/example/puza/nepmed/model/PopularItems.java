package com.example.puza.nepmed.model;

public class PopularItems {

    private int allServicesImage;
    private String allServicesTitle;

    public PopularItems(int allServicesImage, String allServicesTitle) {
        this.allServicesImage = allServicesImage;
        this.allServicesTitle = allServicesTitle;
    }

    public int getAllServicesImage() {
        return allServicesImage;
    }

    public void setAllServicesImage(int allServicesImage) {
        this.allServicesImage = allServicesImage;
    }

    public String getAllServicesTitle() {
        return allServicesTitle;
    }

    public void setAllServicesTitle(String allServicesTitle) {
        this.allServicesTitle = allServicesTitle;
    }
}
