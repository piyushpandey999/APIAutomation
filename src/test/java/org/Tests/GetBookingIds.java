package org.Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.BaseSetup.BaseClass;
import org.testng.annotations.Test;

public class GetBookingIds extends BaseClass {


    @Test
    public void getBookingIds() {
        Response response = RestAssured.given()
                .when().get(getUrl("getBookingIdsURL"))
                .then().extract().response();
        response.prettyPrint();
    }
}
