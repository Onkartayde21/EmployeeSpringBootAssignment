package com.example.SpringBootAssignment.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PropertiesService {

    @Value("${spring.application.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @Value("${app.description}")
    private String appDescription;

    public String getAppName() {
        return appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public String getAppDescription() {
        return appDescription;
    }
}
