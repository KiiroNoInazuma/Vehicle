package com.app.transport;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static java.util.Objects.isNull;
import static java.util.Objects.requireNonNullElse;

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
                    "remoteEngineStart = " + remoteEngineStart +
                    ", keylessEntry = " + keylessEntry;
        }
    }

    public static class Insurance {
        private final String durationInsurance;
        private final double premSum;
        private final String isnInsurance;

        public Insurance(String durationInsurance, double premSum, String isnInsurance) {
            this.durationInsurance = requireNonNullElse(checkExpirationDateInsurance(durationInsurance),
                    "Дата окончания страховки не введена");
            this.premSum = premSum;
            this.isnInsurance = isnInsuranceValidate(isnInsurance);
        }

        private String checkExpirationDateInsurance(String date) {
            final LocalDate dateInsurance = LocalDate.parse(Objects.requireNonNullElse(date, "01.01.0001"),
                    DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            if (LocalDate.now().isAfter(dateInsurance) && date != null) {
                return "\u001B[31mВнимание! Страховка на автомобиль просрочена\u001B[0m";
            }
            return date;
        }

        private String isnInsuranceValidate(String isn) {
            final String regex = "[A-Za-z0-9]{9}";
            return setDefaultValue(isn).toUpperCase().matches(regex) ? isn :
                    "\u001B[31mНомер страховки некорректный!\u001B[0m --> " + isn;
        }

        @Override
        public String toString() {
            return "Insurance: " +
                    "durationInsurance = " + durationInsurance +
                    ", premSum = " + premSum +
                    ", isnInsurance = " + isnInsurance;
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
    private final Insurance insurance;

    public Vehicle(String brand, String model, double engineVolume, String color, int year, String country,
                   String transmission, String bodyType, String regNum, int seats, Key key, Insurance insurance) {
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
        this.insurance = isNull(insurance) ? new Insurance(null, 0.0, null) : insurance;
        System.out.println(this);
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

    private static String setDefaultValue(String value) {
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
                "\nbrand = " + brand +
                ", \nmodel = " + model +
                ", \nengineVolume = " + engineVolume +
                ", \ncolor = " + color +
                ", \nyear = " + year +
                ", \ncountry = " + country +
                ", \ntransmission = " + transmission +
                ", \nbodyType = " + bodyType +
                ", \nregNum = " + regNum +
                ", \nseats = " + seats +
                ", \ntires = " + (tires ? "зимние" : "летние") +
                ", \n" + key +
                ", \n" + insurance;
    }
}