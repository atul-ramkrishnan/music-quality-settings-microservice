package com.microservices.assignment2.musicstreaming;
import org.springframework.beans.factory.annotation.Autowired;
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
}
