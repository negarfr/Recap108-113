package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Get04b extends HerOkuAppBaseUrl {

    /*
        Given
            https://restful-booker.herokuapp.com/booking/8065
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json”
        And
            Response body should be like;
                     {
                    "firstname": "John",
                    "lastname": "Smith",
                    "totalprice": 111,
                    "depositpaid": true,
                    "bookingdates": {
                        "checkin": "2018-01-01",
                        "checkout": "2019-01-01"
                    },
                    "additionalneeds": "Breakfast"
                }
     */

 @Test
 public void get04(){

     spec.pathParams("first","booking","second", 8065);

     // set the expecteddata

     // send the Req and GET the Response
     Response response = given().spec(spec).when().get("/{first}/{second}");
     response.prettyPrint();

     // assertion ==> we use jsonPath() this time to manipulate the Data
     //Do assertion
     JsonPath jsonPath = response.jsonPath();

     //sofe Assertion

     //1st: Create SoftAssert Object- befroe this we add our dependency from Maven Respotory
     SoftAssert softAssert = new SoftAssert();

     //2nd : Do Assertion
     softAssert.assertEquals( response.statusCode(),200);
     softAssert.assertEquals(response.contentType(),"application/json; charset=utf-8");
     softAssert.assertEquals(jsonPath.getString("firstname"),"John");
     softAssert.assertEquals(jsonPath.getString("lastname"),"Smith");
     softAssert.assertEquals(jsonPath.getInt("totalprice"),111);
     softAssert.assertEquals(jsonPath.getBoolean("depositpaid"),true);
     softAssert.assertEquals(jsonPath.getString("additionalneeds"),"Breakfast");

     softAssert.assertEquals(jsonPath.getString("bookingdates.checkin"),"2018-01-01");
     softAssert.assertEquals(jsonPath.getString("bookingdates.checkout"),"2019-01-01");

     //3rd: AssertAll
     softAssert.assertAll();

 }

 }





