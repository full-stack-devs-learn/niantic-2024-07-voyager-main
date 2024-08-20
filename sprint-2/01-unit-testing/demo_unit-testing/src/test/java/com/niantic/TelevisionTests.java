package com.niantic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TelevisionTests
{
    private Television tv;

    @BeforeEach
    public void setup()
    {
        tv = new Television();
    }

    @Test
    public void newTV_shouldBeOff_whenCreated()
    {
        // arrange
        // act
        // Television tv = new Television();

        // assert
        assertFalse(tv.isOn(), "Because a new TV should be off.");
    }

    @Test
    public void togglePower_shouldTurnTVOn_whenItIsOff()
    {
        // arrange
        // Television tv = new Television();
        int expectedChannel = 3;
        int expectedVolume = 2;

        // act
        tv.togglePower();

        // assert
        boolean isTvOn = tv.isOn();
        int actualChannel = tv.getCurrentChannel();
        int actualVolume = tv.getCurrentVolume();

        assertTrue(isTvOn, "Because the TV was off when I toggled the power.");
        assertEquals(expectedChannel, actualChannel, "Because the TV was just turned on.");
        assertEquals(expectedVolume, actualVolume, "Becuase the TV was just turned on.");

    }

    @Test
    public void togglePower_shouldTurnTVOff_whenItIsOff()
    {
        // arrange
        // Television tv = new Television();
        tv.togglePower();
        int expectedChannel = -1;
        int expectedVolume = -1;

        // act
        tv.togglePower();

        // assert
        boolean isTvOn = tv.isOn();
        int actualChannel = tv.getCurrentChannel();
        int actualVolume = tv.getCurrentVolume();

        assertFalse(isTvOn, "Because the TV was on when I toggled the power.");
        assertEquals(expectedChannel, actualChannel, "Because the TV was just turned off the channel should be -1.");
        assertEquals(expectedVolume, actualVolume, "Because the TV was just turned off the volume should be -1.");

    }

    @ParameterizedTest
    @CsvSource({
            "2, false, 3",
            "3, true, 3",
            "4, true, 4",
            "5, true, 5",
            "6, true, 6",
            "7, true, 7",
            "8, true, 8",
            "9, true, 9",
            "10, true, 10",
            "11, true, 11",
            "12, true, 12",
            "13, true, 13",
            "14, true, 14",
            "15, true, 15",
            "16, false, 3"
    })
    public void changeChannel_shouldSucceed_whenChannelIsInRange(String inputIn, String successIn, String expectedIn)
    {
        // arrange
        int channelInput = Integer.parseInt(inputIn);
        boolean expectedSuccess = Boolean.parseBoolean(successIn);
        int expectedChannel = Integer.parseInt(expectedIn);

        tv.togglePower();

        // act
        boolean didChannelChanged = tv.changeChannel(channelInput);

        // assert
        assertEquals(expectedSuccess, didChannelChanged, "Because the input channel was : " + channelInput);

        int actualChannel = tv.getCurrentChannel();
        assertEquals(expectedChannel, actualChannel, "Because the input channel was : " + channelInput);

    }

    @Test
    public void changeChannel_shouldSucceed_whenChannelIsUpperEdge()
    {
        // arrange
        // Television tv  = new Television();
        int expectedChannel = 15;
        tv.togglePower();

        // act
        boolean didChannelChanged = tv.changeChannel(expectedChannel);

        // assert
        assertTrue(didChannelChanged, "Because the new channel was in the range of the available channels.");

        int actualChannel = tv.getCurrentChannel();
        assertEquals(expectedChannel, actualChannel, "Because the channel should have changed.");

    }

    @Test
    public void changeChannel_shouldFail_whenChannelIsAboveUpperEdge()
    {
        // arrange
        // Television tv  = new Television();
        int newChannel = 16;
        int expectedChannel = 3;
        tv.togglePower();

        // act
        boolean didChannelChanged = tv.changeChannel(newChannel);

        // assert
        assertFalse(didChannelChanged, "Because the new channel was not in the range of the available channels.");

        int actualChannel = tv.getCurrentChannel();
        assertEquals(expectedChannel, actualChannel, "Because the channel should not have changed.");

    }

}