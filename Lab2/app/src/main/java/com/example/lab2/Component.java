package com.example.lab2;

public class Component {
    private String title;
    private int price;
    private String manufacturer;
    private String description;

    public Component(String title, int price, String manufacturer, String description) {
        this.title = title;
        this.price = price;
        this.manufacturer = manufacturer;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
