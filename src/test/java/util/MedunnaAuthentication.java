package util;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class MedunnaAuthentication {

    // here we send post request to get Token
    //1- create method to get token as return
    public static String generateToken(){

        Map<String, Object> json = new HashMap<>();
        json.put("password","John.123");
        json.put("rememberMe",true);
        json.put("username","john_doe");


        Response response=given().contentType(ContentType.JSON).body(json).when().post("https://medunna.com/api/");
        return response.jsonPath().getString("id_token");
    }


}
/*
{   is the body gave us token in postman, we use here to create map for the body() here to send post request
  "password": "John.123",
  "rememberMe": true,
  "username": "john_doe"
}

 */