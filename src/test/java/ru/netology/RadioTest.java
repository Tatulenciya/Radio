package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    @Test
    public void shouldSetWaveAndVolume() {
        Radio radio = new Radio(2, 35, 10);


        radio.setCurrentWave(5);
        radio.setCurrentVolume(62);

        Assertions.assertEquals(5, radio.getCurrentWave());
        Assertions.assertEquals(62, radio.getCurrentVolume());

    }

    @Test
    public void shouldSetFirstWaveAndVolume() {
        Radio radio = new Radio(5,35, 10);

        radio.setCurrentWave(0);
        radio.setCurrentVolume(0);

        Assertions.assertEquals(0, radio.getCurrentWave());
        Assertions.assertEquals(0, radio.getCurrentVolume());

    }

    @Test
    public void shouldSetLatestWaveAndVolume() {
        Radio radio = new Radio(5,35, 10);

        radio.setCurrentWave(9);
        radio.setCurrentVolume(100);

        Assertions.assertEquals(9, radio.getCurrentWave());
        Assertions.assertEquals(100, radio.getCurrentVolume());

    }

    @Test
    public void shoulNotdSetWaveWithNegativeValues() {
        Radio radio = new Radio(5,35, 10);

        radio.setCurrentWave(-1);
        radio.setCurrentVolume(-1);

        Assertions.assertEquals(5, radio.getCurrentWave());
        Assertions.assertEquals(35, radio.getCurrentVolume());

    }

    @Test
    public void shouldNotSetWaveWithBigValues() {
        Radio radio = new Radio(5,35, 10);

        radio.setCurrentWave(10);
        radio.setCurrentVolume(101);

        Assertions.assertEquals(5, radio.getCurrentWave());
        Assertions.assertEquals(35, radio.getCurrentVolume());

    }

    @Test
    public void shouldNextWaveAndVolume() {
        Radio radio = new Radio(4,35, 10);

        radio.next();
        radio.addVolume();

        Assertions.assertEquals(5, radio.getCurrentWave());
        Assertions.assertEquals(36, radio.getCurrentVolume());
    }

    @Test
    public void nextWaveConditionCheck() {
        Radio radio = new Radio(9,100, 10);

        radio.next();
        radio.addVolume();

        Assertions.assertEquals(0, radio.getCurrentWave());
        Assertions.assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void prevWaveConditionCheck() {
        Radio radio = new Radio(0,0, 10);

        radio.prev();
        radio.reduceVolome();

        Assertions.assertEquals(9, radio.getCurrentWave());
        Assertions.assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void nextWave() {
        Radio radio = new Radio(0,35, 10);

        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5};
        int[] actual = new int[15];

        for (int i = 0; i < expected.length; i++) {
            actual[i] = radio.next();
        }
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void prevWave() {
        Radio radio = new Radio(6,35, 10);

        int[] expected = {5, 4, 3, 2, 1, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] actual = new int[15];

        for (int i = 0; i < expected.length; i++) {
            actual[i] = radio.prev();
        }
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void addedVolume() {
        Radio radio = new Radio(5,0, 10);

        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 100, 100};
        int[] actual = new int[102];

        for (int i = 0; i < expected.length; i++) {
            actual[i] = radio.addVolume();
        }
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void reducedVolume() {
        Radio radio = new Radio(5,100, 10);

        int[] expected = {99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88, 87, 86, 85, 84, 83, 82, 81, 80, 79, 78, 77, 76, 75, 74, 73, 72, 71, 70, 69, 68, 67, 66, 65, 64, 63, 62, 61, 60, 59, 58, 57, 56, 55, 54, 53, 52, 51, 50, 49, 48, 47, 46, 45, 44, 43, 42, 41, 40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 0, 0};
        int[] actual = new int[102];

        for (int i = 0; i < expected.length; i++) {
            actual[i] = radio.reduceVolome();
        }
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSetWave() {
        Radio radio = new Radio();

        radio.setCurrentWave(8);

        int expected = 8;
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
    public void shouldNotSetWaveMoreThanLast() {
        Radio radio = new Radio();

        radio.setCurrentWave(10);

        int expected = 0;
        int actual = radio.getCurrentWave();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldNotSetWaveLessThanFirst() {
        Radio radio = new Radio();

        radio.setCurrentWave(-1);

        int expected = 0;
        int actual = radio.getCurrentWave();

        Assertions.assertEquals(expected, actual);

    }

}
