package com.niantic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest
{
    @Test
    public void add_shouldReturn_sumOfNumbers()
    {
        // arrange
        Calculator calculator = new Calculator();
        int firstNumber = 10;
        int secondNumber = 3;
        double expected = 13;

        // act
        double actual = calculator.add(firstNumber,secondNumber);

        // assert
        assertEquals(expected, actual, "Because it should have added 10 + 3");

    }

    // The lazy example
    @Test
    public void add()
    {
        Calculator calculator = new Calculator();
        assertEquals(13, calculator.add(10,3));
    }

}