package com.example.sneakers;

/**
 * Класс, представляющий баскетбольные кроссовки.
 */
public class BasketballSneakers extends Sneakers {
    public BasketballSneakers(String name, double cost, Producer producer) {
        super(name, cost, "Basketball", producer);
    }
}