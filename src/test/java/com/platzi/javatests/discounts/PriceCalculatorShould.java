package com.platzi.javatests.discounts;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceCalculatorShould {


    private PriceCalculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new PriceCalculator();
    }

    @Test
    void totalZeroWhenThereArePrices() {
        Assertions.assertEquals(0.0, calculator.getTotal());
    }

    @Test
    void totalIsTheSumOfPrices() {
        calculator.addPrice(10.2);
        calculator.addPrice(15.5);
        Assertions.assertEquals(25.7, calculator.getTotal());
    }

    @Test
    void applyDiscountToPrices() {
        calculator.addPrice(12.5);
        calculator.addPrice(17.5);

        calculator.setDiscount(50);

        Assertions.assertEquals(15.0, calculator.getTotal());
    }
}