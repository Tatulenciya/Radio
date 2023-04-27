package ru.netology;


public class Radio {
    public int currentWave;
    public int currentVolume;

    public int getCurrentWave() {
        return currentWave;
    }

    public void setCurrentWave(int newCurrentWave) {
        if (newCurrentWave < 0) {
            return;
        }
        if (newCurrentWave > 9) {
            return;
        }
        currentWave = newCurrentWave;
    }

    public int next() {
        int target = currentWave + 1;
        if (currentWave == 9) {
            target = 0;
        }
        setCurrentWave(target);
        return currentWave;
    }

    public int prev() {
        int previous = currentWave - 1;
        if (currentWave == 0) {
            previous = 9;
        }
        setCurrentWave(previous);
        return currentWave;
    }

}