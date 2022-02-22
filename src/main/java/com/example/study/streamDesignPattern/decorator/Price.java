package com.example.study.streamDesignPattern.decorator;

public class Price {
    public Price(String price) {
        this.price = price;
    }

    private final String price;

    public String getPrice() {
        return price;
    }
}
