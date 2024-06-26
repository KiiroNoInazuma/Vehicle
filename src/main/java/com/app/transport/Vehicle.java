package com.app.transport;

import static java.util.Objects.isNull;

public class Vehicle {
    private final String brand;
    private final String model;
    private double engineVolume;
    private String color;
    private final int year;
    private final String country;
    private String transmission;
    private final String bodyType;
    private String regNum;
    private int seats;
    private final boolean areWinterTires;

    public Vehicle(String brand, String model, double engineVolume, String color, int year,
                   String country, String transmission, String bodyType, String regNum, int seats, boolean areWinterTires) {
        this.brand = setDefaultValue(brand);
        this.model = setDefaultValue(model);
        this.engineVolume = setEngineVolume(engineVolume);
        this.color = setDefaultValueColor(color);
        this.year = setDefaultValue(year);
        this.country = setDefaultValue(country);
        this.transmission = setDefaultValue(transmission);
        this.bodyType = setDefaultValue(bodyType);
        this.regNum = setDefaultValue(regNum);
        this.seats = seats <= 0 ? 1 : seats;
        this.areWinterTires = areWinterTires;
    }

    private String setDefaultValue(String value) {
        if (isNull(value) || value.isBlank()) {
            return "default";
        }
        return value;
    }

    public String setDefaultValueColor(String color) {
        if (isNull(color) || color.isBlank()) {
            return "белый";
        }
        this.color = color;
        return color;
    }

    public double setEngineVolume(double value) {
        if (value <= 0) {
            return 1.5;
        } else {
            engineVolume = value;
        }
        return value;
    }

    private int setDefaultValue(int value) {
        if (value <= 0) {
            return 2000;
        }
        return value;
    }


    @Override
    public String toString() {
        return "Vehicle: " +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engineVolume=" + engineVolume +
                ", color='" + color + '\'' +
                ", year=" + year +
                ", country=" + country +
                ", transmission=" + transmission +
                ", bodyType=" + bodyType +
                ", regNum=" + regNum +
                ", seats=" + seats +
                ", areWinterTires=" + areWinterTires;
    }
}