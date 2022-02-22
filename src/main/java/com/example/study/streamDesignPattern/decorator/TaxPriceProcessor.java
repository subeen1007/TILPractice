package com.example.study.streamDesignPattern.decorator;

public class TaxPriceProcessor implements PriceProcessor
{
    @Override
    public Price process(Price price) {
        return new Price(price.getPrice() + ", then applied tax");
    }
}
