// File: Car.java
package com.example.car;

public final class Car {
    private final String make;       // производитель, обяз.
    private final String model;      // модель, обяз.
    private final int year;          // год, обяз.
    private final String color;      // опционально
    private final Engine engine;     // опционально
    private final Transmission transmission; // опционально
    private final int seats;         // опционально
    private final boolean gps;       // опционально

    private Car(Builder b) {
        this.make = b.make;
        this.model = b.model;
        this.year = b.year;
        this.color = b.color;
        this.engine = b.engine;
        this.transmission = b.transmission;
        this.seats = b.seats;
        this.gps = b.gps;
    }

    // Геттеры
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public String getColor() { return color; }
    public Engine getEngine() { return engine; }
    public Transmission getTransmission() { return transmission; }
    public int getSeats() { return seats; }
    public boolean hasGps() { return gps; }

    @Override
    public String toString() {
        return String.format("Car{%s %s, %d, color=%s, engine=%s, trans=%s, seats=%d, gps=%b}",
                make, model, year, color, engine, transmission, seats, gps);
    }

    // Builder
    public static class Builder {
        // обязательные параметры
        private final String make;
        private final String model;
        private final int year;

        // опциональные с дефолтами
        private String color = "unspecified";
        private Engine engine = null;
        private Transmission transmission = Transmission.MANUAL;
        private int seats = 4;
        private boolean gps = false;

        public Builder(String make, String model, int year) {
            if (make == null || make.isBlank()) throw new IllegalArgumentException("make required");
            if (model == null || model.isBlank()) throw new IllegalArgumentException("model required");
            if (year < 1886) throw new IllegalArgumentException("invalid year");
            this.make = make;
            this.model = model;
            this.year = year;
        }

        public Builder color(String color) {
            this.color = color == null ? this.color : color;
            return this;
        }

        public Builder engine(Engine engine) {
            this.engine = engine;
            return this;
        }

        public Builder transmission(Transmission t) {
            if (t != null) this.transmission = t;
            return this;
        }

        public Builder seats(int seats) {
            if (seats <= 0) throw new IllegalArgumentException("seats must be > 0");
            this.seats = seats;
            return this;
        }

        public Builder gps(boolean gps) {
            this.gps = gps;
            return this;
        }

        public Car build() {
            // дополнительная валидация: если у машины мощный двигатель, то не меньше 2 мест и т.д. (пример)
            return new Car(this);
        }
    }
}
