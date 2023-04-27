package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    @Test
    public void shouldSetWave() {
        Radio radio = new Radio();

        radio.setCurrentWave(5);

        int expected = 5;
        int actual = radio.getCurrentWave();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldSetFirstWave() {
        Radio radio = new Radio();

        radio.currentWave = 5;
        radio.setCurrentWave(0);

        int expected = 0;
        int actual = radio.getCurrentWave();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldSetLatestWave() {
        Radio radio = new Radio();

        radio.setCurrentWave(9);

        int expected = 9;
        int actual = radio.getCurrentWave();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shoulNotdSetWaveWithNegativeValues() {
        Radio radio = new Radio();

        radio.setCurrentWave(-1);

        int expected = 0;
        int actual = radio.getCurrentWave();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldNotSetWaveWithBigValues() {
        Radio radio = new Radio();

        radio.setCurrentWave(10);

        int expected = 0;
        int actual = radio.getCurrentWave();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldNextWave() {
        Radio radio = new Radio();

        radio.currentWave = 4;
        radio.next();

        int expected = 5;
        int actual = radio.getCurrentWave();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void nextWaveConditionCheck() {
        Radio radio = new Radio();

        radio.currentWave = 9;
        radio.next();

        int expected = 0;
        int actual = radio.getCurrentWave();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void nextWave() {
        Radio radio = new Radio();

        radio.currentWave = 0;
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5};
        int[] actual = new int[15];

        for (int i = 0; i < expected.length; i++) {
            actual[i] = radio.next();
        }
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void prevWave() {
        Radio radio = new Radio();

        radio.currentWave = 6;
        int[] expected = {5, 4, 3, 2, 1, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] actual = new int[15];

        for (int i = 0; i < expected.length; i++) {
            actual[i] = radio.prev();
        }
        Assertions.assertArrayEquals(expected, actual);
    }

}
