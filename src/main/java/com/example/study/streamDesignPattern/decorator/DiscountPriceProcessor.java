package com.example.study.streamDesignPattern.decorator;

public class DiscountPriceProcessor implements PriceProcessor{

    @Override
    public Price process(Price price) {
        return new Price(price.getPrice() + ", then applied discount");
    }
}
