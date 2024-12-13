package com.example.sneakers;

/**
 * Класс, представляющий футбольные кроссовки.
 */
public class FootballSneakers extends Sneakers {
    public FootballSneakers(String name, double cost, Producer producer) {
        super(name, cost, "Football", producer);
    }
}