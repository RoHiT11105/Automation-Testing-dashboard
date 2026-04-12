package com.automation.automationregression.service;

import com.automation.automationregression.entity.TestCase;
import com.automation.automationregression.repository.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestCaseService {

    @Autowired
    private TestCaseRepository testCaseRepository;

    public TestCase saveResult(TestCase testCase) {
        return testCaseRepository.save(testCase);
    }
}