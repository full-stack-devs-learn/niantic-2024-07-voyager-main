package com.niantic;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class BowTest
{

    @Test
    public void arrow_shouldReplenish_within5Seconds_afterAttack() throws InterruptedException
    {
        // arrange
        Bow bow = new Bow("My bow", 10, "standard", 5);

        // act
        bow.attack();

        // arrange
        assertEquals(9, bow.getArrowCount());
        Thread.sleep(5000);
        assertEquals(10, bow.getArrowCount());
    }


    @Test
    public void bow_shouldCharge_every2seconds() throws InterruptedException
    {
        // arrange/act
        Bow bow = new Bow("My bow", 10, "standard", 5);

        // arrange
        assertEquals(0, bow.getPercentCharged());
        Thread.sleep(5000);
        assertEquals(100, bow.getPercentCharged());
    }
}