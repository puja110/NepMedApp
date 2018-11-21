package com.example.puza.nepmed.model;

public class LatestItems {

    private int image;
    private String title;
    private String Price1;
    private String price2;
    private String addToCart;

    public LatestItems(int image, String title, String price1, String price2, String addToCart) {
        this.image = image;
        this.title = title;
        Price1 = price1;
        this.price2 = price2;
        this.addToCart = addToCart;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice1() {
        return Price1;
    }

    public void setPrice1(String price1) {
        Price1 = price1;
    }

    public String getPrice2() {
        return price2;
    }

    public void setPrice2(String price2) {
        this.price2 = price2;
    }

    public String getAddToCart() {
        return addToCart;
    }

    public void setAddToCart(String addToCart) {
        this.addToCart = addToCart;
    }
}
