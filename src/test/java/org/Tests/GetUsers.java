package org.Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.BaseSetup.BaseClass;
import org.Utils.ConfigReader;
import org.testng.annotations.Test;


@Test(groups = "GetUsers")
public class GetUsers extends BaseClass {


    @Test
    public void getUsers(){
        Response response = RestAssured.given()
                .header("x-api-key","reqres-free-v1")
                .queryParam("page",2)
                .when().get(getUrl("getUsers")).then().extract().response();
        response.prettyPrint();
    }
}
