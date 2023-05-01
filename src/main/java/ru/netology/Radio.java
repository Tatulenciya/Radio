package ru.netology;


public class Radio {
    private int currentWave;
    private int currentVolume;
    private int firstWave = 0;
    private int lastWave;


    public Radio (int currentWave, int currentVolume, int size) {
        this.currentWave = currentWave;
        this.currentVolume = currentVolume;
        this.lastWave = size - 1;
    }

    public Radio () {
        lastWave = 9;
    }


    public int getCurrentWave() {
        return currentWave;
    }

    public void setCurrentWave(int newCurrentWave) {
        if (newCurrentWave < firstWave) {
            return;
        }
        if (newCurrentWave > lastWave) {
            return;
        }
        currentWave = newCurrentWave;
    }

    public int next() {
        int target = currentWave + 1;
        if (currentWave == lastWave) {
            target = firstWave;
        }
        setCurrentWave(target);
        return currentWave;
    }

    public int prev() {
        int previous = currentWave - 1;
        if (currentWave == firstWave) {
            previous = lastWave;
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