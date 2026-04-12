package com.automation.automationregression.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data   // 🔥 THIS FIXES EVERYTHING
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String testName;
    private String testType;
    private String testStatus;

    private String screenshotPath;
    private String errorMessage;
}