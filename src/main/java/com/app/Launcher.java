package com.app;

import com.app.transport.Vehicle;

public class Launcher {
    public static void main(String[] args) {

        new Vehicle("Lada", "Granta", 1.7, "желтый", 2015,
                "Россия", "механическая", "седан", "E846PO199", 5, new Vehicle.Key(true, true));
        /*Vehicle audi = new Vehicle("Audi", "A8 50 L TDI quattro", 3.0, "черный", 2020, "Германия");
        Vehicle bmw = new Vehicle("BMW", "Z8", 3.0, "черный", 2021, "Германия");
        Vehicle kia = new Vehicle("Kia", "Sportage", 2.4, "красный", 2018, "Южная Корея");
        Vehicle hyundai = new Vehicle("Hyundai", "Avante", 1.6, "оранжевый", 2016, "Южная Корея");*/
       /* Vehicle testCar = new Vehicle(null, " ", -1, "", -1, null,
                "", "    ", null, -6, null);*/
         //System.out.println(lada);
    }
}
