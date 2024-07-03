package com.app.transport;

import static java.util.Objects.isNull;

public abstract class Transport {
    private final String brand;
    private final String model;
    private final int year;
    private final String country;
    private String color;
    private int maxSpeed;

    public Transport(String brand, String model, int year, String country, String color, int maxSpeed) {
        this.brand = setDefaultValue(brand);
        this.model = setDefaultValue(model);
        this.year = setDefaultValue(year);
        this.country = setDefaultValue(country);
        setColor(color);
        setMaxSpeed(maxSpeed);
    }

    public void setColor(String color) {
        if (isNull(color) || color.isBlank()) {
            this.color = "белый";
        } else {
            this.color = color;
        }
    }

    public abstract String refill();

    public void setMaxSpeed(int speed) {
        if (speed <= 0) {
            maxSpeed = 10;
        } else {
            maxSpeed = speed;
        }
    }

    protected static String setDefaultValue(String value) {
        if (isNull(value) || value.isBlank()) {
            return "default";
        }
        return value;
    }

    protected int setDefaultValue(int value) {
        if (value <= 0) {
            return 2000;
        }
        return value;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "\nbrand = " + brand +
                " \nmodel = " + model +
                " \ncolor = " + color +
                " \nyear = " + year +
                " \ncountry = " + country +
                " \nmaxSpeed = " + maxSpeed +
                " \nrefill = " + refill();
    }
}
