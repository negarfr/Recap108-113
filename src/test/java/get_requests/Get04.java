package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Get04 extends HerOkuAppBaseUrl {

    /*
        Given
            https://restful-booker.herokuapp.com/booking/71926
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json”
        And
            Response body should be like;
                     {
                        "firstname": "Josh",
                        "lastname": "Allen",
                        "totalprice": 111,
                        "depositpaid": true,
                        "bookingdates": {
                            "checkin": "2018-01-01",
                            "checkout": "2019-01-01"
                        },
                        "additionalneeds": "super bowls"
                    }
     */

 @Test
 public void get04(){

     spec.pathParams("first","booking","second", 8065);

     // set the expecteddata

     // send the Req and GET the Response
     Response response = given().spec(spec).when().get("/{first}/{second}");
     response.prettyPrint();

     // assertion ==> we use jsonPath() this time to manipulate the Data == here we do not have expectedData so we
     //Do assertion             // we create JsonPath object
     JsonPath jsonPath = response.jsonPath();// to extract the data from outside the body.JsonPath is very useful to Mantipulate the data

     assertEquals(200,response.statusCode());
     assertEquals("application/json",response.contentType());
     assertEquals("Jane",jsonPath.getString("firstname"));
     assertEquals("Doe",jsonPath.getString("lastname"));
     assertEquals(111,jsonPath.getInt("totalprice"));
     assertEquals(true,jsonPath.getBoolean("depositpaid"));
     assertEquals("2018-01-01",jsonPath.getString("bookingdates.checkin"));
     assertEquals( "2019-01-01",jsonPath.getString("bookingdates.checkout"));
     assertEquals("Extra pillows please",jsonPath.getString("additionalneeds"));




 }




}
