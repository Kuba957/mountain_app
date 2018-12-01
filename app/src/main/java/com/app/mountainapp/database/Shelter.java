package com.app.mountainapp.database;

import android.graphics.Bitmap;

public class Shelter {

    private String shelter_name;
    private Bitmap shelter_image;

    public Shelter(){

    }

    public Shelter(String shelter_name,Bitmap shelter_image) {
        this.shelter_name = shelter_name;
        this.shelter_image = shelter_image;
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
}
