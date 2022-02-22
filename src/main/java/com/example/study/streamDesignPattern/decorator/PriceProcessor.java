package com.example.study.streamDesignPattern.decorator;

@FunctionalInterface
public interface PriceProcessor {
    Price process(Price price);

    default PriceProcessor andThen(PriceProcessor next){
        return price -> next.process(process(price));
    }
}
