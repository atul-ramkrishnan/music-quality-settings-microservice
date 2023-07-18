package com.microservices.assignment2.musicstreaming.controller;

import com.microservices.assignment2.musicstreaming.bean.QualitySettings;
import com.microservices.assignment2.musicstreaming.configuration.QualityConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quality-settings")
public class QualityController {
    private QualityConfiguration qualityConfiguration;

    @Autowired
    public QualityController(QualityConfiguration qualityConfiguration) {
        this.qualityConfiguration = qualityConfiguration;
    }

    @GetMapping
    public QualitySettings getQualitySettings(@RequestParam("subscription") String subscription) {
        int minBitrate;
        int maxBitrate;

        switch (subscription) {
            case "free":
                minBitrate = qualityConfiguration.getFreeMinBitrate();
                maxBitrate = qualityConfiguration.getFreeMaxBitrate();
                break;
            case "premium":
                minBitrate = qualityConfiguration.getPremiumMinBitrate();
                maxBitrate = qualityConfiguration.getPremiumMaxBitrate();
                break;
            case "vip":
                minBitrate = qualityConfiguration.getVipMinBitrate();
                maxBitrate = qualityConfiguration.getVipMaxBitrate();
                break;
            default:
                throw new IllegalArgumentException("Invalid subscription level");
        }

        return new QualitySettings(minBitrate, maxBitrate);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
