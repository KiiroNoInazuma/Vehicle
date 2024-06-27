package com.app.transport;

import java.time.LocalDate;

import static java.util.Objects.isNull;

public class Vehicle {

    public static class Key {
        private final boolean remoteEngineStart;
        private final boolean keylessEntry;

        public Key(boolean remoteEngineStart, boolean keylessEntry) {
            this.remoteEngineStart = remoteEngineStart;
            this.keylessEntry = keylessEntry;
        }


        @Override
        public String toString() {
            return "Key: " +
                    "remoteEngineStart=" + remoteEngineStart +
                    ", keylessEntry=" + keylessEntry;
        }
    }

    private final String brand;
    private final String model;
    private double engineVolume;
    private String color;
    private final int year;
    private final String country;
    private final String transmission;
    private final String bodyType;
    private String regNum;
    private final int seats;
    private final boolean tires;
    private final Key key;

    public Vehicle(String brand, String model, double engineVolume, String color, int year,
                   String country, String transmission, String bodyType, String regNum, int seats, Key key) {
        this.brand = setDefaultValue(brand);
        this.model = setDefaultValue(model);
        setEngineVolume(engineVolume);
        setDefaultValueColor(color);
        this.year = setDefaultValue(year);
        this.country = setDefaultValue(country);
        this.transmission = setDefaultValue(transmission);
        this.bodyType = setDefaultValue(bodyType);
        setRegNumValidate(regNum);
        this.seats = seats <= 0 ? 1 : seats;
        this.tires = identifyTires();
        this.key = isNull(key) ? new Key(false, false) : key;
    }

    public void setRegNumValidate(String regNum) {
        final String regex = "[АВЕКМНОРСТУХABEKMHOPCTYX]\\d{3}[АВЕКМНОРСТУХABEKMHOPCTYX]{2}\\d{2,3}";
        final boolean checkRegNum = setDefaultValue(regNum).toUpperCase().matches(regex);
        if (checkRegNum) {
            this.regNum = regNum;
        } else {
            System.out.println("\u001B[31mВнимание! Ошибка ввода регистрационного номера " + brand + " " + model + "\u001B[0m");
            this.regNum = "х000хх000";
        }
    }

    private String setDefaultValue(String value) {
        if (isNull(value) || value.isBlank()) {
            return "default";
        }
        return value;
    }

    public void setDefaultValueColor(String color) {
        if (isNull(color) || color.isBlank()) {
            this.color = "белый";
        } else {
            this.color = color;
        }
    }

    public void setEngineVolume(double value) {
        if (value <= 0) {
            engineVolume = 1.5;
        } else {
            engineVolume = value;
        }
    }

    private int setDefaultValue(int value) {
        if (value <= 0) {
            return 2000;
        }
        return value;
    }

    private boolean identifyTires() {
        int value = LocalDate.now().getMonth().getValue();
        switch (value) {
            case 1, 2, 3, 11, 12 -> {
                return true;
            }
        }
        return false;
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
                ", tires=" + (tires ? "зимние" : "летние") +
                ", " + key;
    }
}