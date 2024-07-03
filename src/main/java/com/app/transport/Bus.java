package com.app.transport;

public class Bus extends Transport {
    public Bus(String brand, String model, int year, String country, String color, int maxSpeed) {
        super(brand, model, year, country, color, maxSpeed);
    }

    @Override
    public String refill() {
        return "refill: Можно заправлять бензином или дизелем на заправке";
    }
}
