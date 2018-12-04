package com.app.mountainapp.database;

import android.graphics.Bitmap;

public class Shelter {

    private String shelter_name;
    private Bitmap shelter_image;
    private String phoneNumber;
    private String eMail;
    private int placeNumber;
    private boolean cardPayment;
    private int heightASL;
    private String webpage;

    private boolean expanded;

    public Shelter(){

    }

    public Shelter(String shelter_name, Bitmap shelter_image, String phoneNumber) {
        this.shelter_name = shelter_name;
        this.shelter_image = shelter_image;
        this.phoneNumber = phoneNumber;
    }

    public String getShelter_name() {
        return shelter_name;
    }

    public void setShelter_name(String shelter_name) {
        this.shelter_name = shelter_name;
    }

    public Bitmap getShelter_image() {
        return shelter_image;
    }

    public void setShelter_image(Bitmap shelter_image) {
        this.shelter_image = shelter_image;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public boolean isCardPayment() {
        return cardPayment;
    }

    public void setCardPayment(boolean cardPayment) {
        this.cardPayment = cardPayment;
    }

    public int getHeightASL() {
        return heightASL;
    }

    public void setHeightASL(int heightASL) {
        this.heightASL = heightASL;
    }

    public String getWebpage() {
        return webpage;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}
