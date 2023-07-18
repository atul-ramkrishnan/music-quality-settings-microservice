package com.microservices.assignment2.musicstreaming.configuration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Component
@ConfigurationProperties(prefix = "music-streaming")
public class QualityConfiguration {
    private int freeMinBitrate;
    private int freeMaxBitrate;
    private int premiumMinBitrate;
    private int premiumMaxBitrate;
    private int vipMinBitrate;
    private int vipMaxBitrate;

    // Getters and setters
    public int getFreeMinBitrate() {
        return freeMinBitrate;
    }

    public void setFreeMinBitrate(int freeMinBitrate) {
        this.freeMinBitrate = freeMinBitrate;
    }

    public int getFreeMaxBitrate() {
        return freeMaxBitrate;
    }

    public void setFreeMaxBitrate(int freeMaxBitrate) {
        this.freeMaxBitrate = freeMaxBitrate;
    }

    public int getPremiumMinBitrate() {
        return premiumMinBitrate;
    }

    public void setPremiumMinBitrate(int premiumMinBitrate) {
        this.premiumMinBitrate = premiumMinBitrate;
    }

    public int getPremiumMaxBitrate() {
        return premiumMaxBitrate;
    }

    public void setPremiumMaxBitrate(int premiumMaxBitrate) {
        this.premiumMaxBitrate = premiumMaxBitrate;
    }

    public int getVipMinBitrate() {
        return vipMinBitrate;
    }

    public void setVipMinBitrate(int vipMinBitrate) {
        this.vipMinBitrate = vipMinBitrate;
    }

    public int getVipMaxBitrate() {
        return vipMaxBitrate;
    }

    public void setVipMaxBitrate(int vipMaxBitrate) {
        this.vipMaxBitrate = vipMaxBitrate;
    }
}