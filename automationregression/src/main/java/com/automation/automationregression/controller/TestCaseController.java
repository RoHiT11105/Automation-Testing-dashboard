package com.automation.automationregression.controller;

import com.automation.automationregression.entity.TestCase;
import com.automation.automationregression.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/testcases")
public class TestCaseController {

    @Autowired
    private TestCaseService testCaseService;

    @PostMapping("/save")
    public TestCase saveTest(@RequestBody TestCase testCase) {
        return testCaseService.saveResult(testCase);
    }
}