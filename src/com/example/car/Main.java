// File: Main.java
package com.example.car;

public class Main {
    public static void main(String[] args) {
        com.example.car.Car sports = com.example.car.CarDirector.buildSportsCar();
        com.example.car.Car family = com.example.car.CarDirector.buildFamilyCar();
        System.out.println(sports);
        System.out.println(family);

        // Прямое использование Builder:
        com.example.car.Car custom = new com.example.car.Car.Builder("Honda", "Civic", 2022)
                .color("Black")
                .engine(new Engine("I4", 158))
                .gps(true)
                .build();
        System.out.println(custom);
    }
}
