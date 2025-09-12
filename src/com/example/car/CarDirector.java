// File: CarDirector.java (опционально, для преднастроек)
package com.example.car;

public final class CarDirector {
    private CarDirector() {}

    public static Car buildSportsCar() {
        return new Car.Builder("Porsche", "911", 2024)
                .color("Red")
                .engine(new Engine("Flat6", 450))
                .transmission(Transmission.AUTOMATIC)
                .seats(2)
                .gps(true)
                .build();
    }

    public static Car buildFamilyCar() {
        return new Car.Builder("Toyota", "RAV4", 2023)
                .color("Blue")
                .engine(new Engine("I4", 200))
                .transmission(Transmission.AUTOMATIC)
                .seats(5)
                .gps(false)
                .build();
    }
}
