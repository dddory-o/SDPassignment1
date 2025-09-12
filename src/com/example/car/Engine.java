// File: Engine.java
package com.example.car;

public final class Engine {
    private final String type;
    private final int horsepower;

    public Engine(String type, int horsepower) {
        if (type == null || type.isBlank()) throw new IllegalArgumentException("type required");
        if (horsepower <= 0) throw new IllegalArgumentException("horsepower > 0");
        this.type = type;
        this.horsepower = horsepower;
    }

    public String getType() { return type; }
    public int getHorsepower() { return horsepower; }

    @Override
    public String toString() {
        return String.format("%s(%dhp)", type, horsepower);
    }
}
