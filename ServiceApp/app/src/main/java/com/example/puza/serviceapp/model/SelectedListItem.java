package com.example.puza.serviceapp.model;

public class SelectedListItem {

    private int image;
    private String name;
    private String description;
    private String buttonOne;
    private String ButtonTwo;

    public SelectedListItem(int image, String name, String description, String buttonOne, String buttonTwo) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.buttonOne = buttonOne;
        ButtonTwo = buttonTwo;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getButtonOne() {
        return buttonOne;
    }

    public void setButtonOne(String buttonOne) {
        this.buttonOne = buttonOne;
    }

    public String getButtonTwo() {
        return ButtonTwo;
    }

    public void setButtonTwo(String buttonTwo) {
        ButtonTwo = buttonTwo;
    }
}
