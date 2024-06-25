package com.app;

import static java.util.Objects.isNull;

public class Vehicle {
    private final String brand;
    private final String model;
    private final double engineVolume;
    private final String color;
    private final int year;
    private final String country;

    public Vehicle(String brand, String model, double engineVolume, String color, int year, String country) {
        this.brand = setDefaultValue(brand);
        this.model = setDefaultValue(model);
        this.engineVolume = setDefaultValue(engineVolume);
        this.color = setDefaultValueColor(color);
        this.year = setDefaultValue(year);
        this.country = setDefaultValue(country);
    }

    private String setDefaultValue(String value) {
        if (isNull(value) || value.isBlank()) {
            return "default";
        }
        return value;
    }

    private String setDefaultValueColor(String value) {
        if (isNull(value) || value.isBlank()) {
            return "белый";
        }
        return value;
    }

    private double setDefaultValue(double value) {
        if (value <= 0) {
            return 1.5;
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
                ", country=" + country;
    }
}