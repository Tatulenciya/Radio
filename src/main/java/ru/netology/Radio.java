package ru.netology;


public class Radio {
    private int currentWave;
    private int currentVolume;

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

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int newCurrentVolume) {
        if (newCurrentVolume < 0) {
            return;
        }
        if (newCurrentVolume > 100) {
            return;
        }
        currentVolume = newCurrentVolume;
    }

    public int addVolume() {
        if (currentVolume < 100) {
            currentVolume = currentVolume + 1;
        }
        return currentVolume;
    }

    public int reduceVolome() {
        if (currentVolume > 0) {
            currentVolume = currentVolume - 1;
        }
        return currentVolume;
    }
}