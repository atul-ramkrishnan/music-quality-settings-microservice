package com.microservices.assignment2.musicstreaming.bean;

public class QualitySettings {
    private int minBitrate;
    private int maxBitrate;

    public QualitySettings() {
        // Default constructor
    }

    public QualitySettings(int minBitrate, int maxBitrate) {
        this.minBitrate = minBitrate;
        this.maxBitrate = maxBitrate;
    }

    // Getters and setters
    public int getMinBitrate() {
        return minBitrate;
    }

    public void setMinBitrate(int minBitrate) {
        this.minBitrate = minBitrate;
    }

    public int getMaxBitrate() {
        return maxBitrate;
    }

    public void setMaxBitrate(int maxBitrate) {
        this.maxBitrate = maxBitrate;
    }
}