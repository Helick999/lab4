package com.example.sneakers;

/**
 * Класс, представляющий кроссовки.
 */
public class Sneakers {
    private String name;
    private double cost;
    private String type;
    private Producer producer;

    public Sneakers(String name, double cost, String type, Producer producer) {
        this.name = name;
        this.cost = cost;
        this.type = type;
        this.producer = producer;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public String getType() {
        return type;
    }

    public Producer getProducer() {
        return producer;
    }
}