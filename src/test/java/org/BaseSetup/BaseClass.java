package org.BaseSetup;

import io.restassured.RestAssured;
import org.Utils.ConfigReader;
import org.testng.annotations.BeforeSuite;

public class BaseClass {


    @BeforeSuite
    public void setup(){
//        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    public String getUrl(String name){
        return ConfigReader.get(name);
    }
}
