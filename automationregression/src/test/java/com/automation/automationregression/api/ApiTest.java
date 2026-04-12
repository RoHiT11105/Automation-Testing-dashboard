package com.automation.automationregression.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest {

    @Test
    public void testGetUsersAPI() {

        // Base URL
        RestAssured.baseURI = "https://reqres.in";

        // Send GET request
        Response response = RestAssured
                .given()
                .when()
                .get("/api/users?page=2");

        // Print response
        System.out.println("Response Body: " + response.asString());

        // Validate status code
        Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch!");

        // Validate response contains expected data
        Assert.assertTrue(response.asString().contains("Michael"),
                "Expected user not found in response!");
    }
}