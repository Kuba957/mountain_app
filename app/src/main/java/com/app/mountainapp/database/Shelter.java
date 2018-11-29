package com.app.mountainapp.database;

public class Shelter {

    private String shelter_name;
    private String phone_number;

    public Shelter(){

    }

    public Shelter(String shelter_name, String phone_number) {
        this.shelter_name = shelter_name;
        this.phone_number = phone_number;
    }

    public String getShelter_name() {
        return shelter_name;
    }

    public void setShelter_name(String shelter_name) {
        this.shelter_name = shelter_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
