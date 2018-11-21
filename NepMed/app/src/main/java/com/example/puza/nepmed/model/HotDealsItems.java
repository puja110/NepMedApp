package com.example.puza.nepmed.model;

public class HotDealsItems {

    private int hImage;
    private String hTitle;
    private String hPrice1;
    private String hPrice2;
    private String hAddToCart;

    public HotDealsItems(int hImage, String hTitle, String hPrice1, String hPrice2, String hAddToCart) {
        this.hImage = hImage;
        this.hTitle = hTitle;
        this.hPrice1 = hPrice1;
        this.hPrice2 = hPrice2;
        this.hAddToCart = hAddToCart;
    }

    public int gethImage() {
        return hImage;
    }

    public void sethImage(int hImage) {
        this.hImage = hImage;
    }

    public String gethTitle() {
        return hTitle;
    }

    public void sethTitle(String hTitle) {
        this.hTitle = hTitle;
    }

    public String gethPrice1() {
        return hPrice1;
    }

    public void sethPrice1(String hPrice1) {
        this.hPrice1 = hPrice1;
    }

    public String gethPrice2() {
        return hPrice2;
    }

    public void sethPrice2(String hPrice2) {
        this.hPrice2 = hPrice2;
    }

    public String getHAddToCart() {
        return hAddToCart;
    }

    public void setHAddToCart(String HAddToCart) {
        this.hAddToCart = HAddToCart;
    }
}
