package post_request;

import base_urls.PetStroeBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Post01 extends PetStroeBaseUrl {

    /*
         Given
           1) https://petstore.swagger.io/v2/store/order
           2)  {
                  "petId": 10,
                  "quantity": 5,
                  "shipDate": "2022-12-04T12:21:46.297+0000",
                  "status": "placed",
                  "complete": true
                }
        When
            I send POST Request to the Url
        Then
            Status code is 200
        And
            response body is like {
                                    "id": 9223372036854568295,
                                    "petId": 10,
                                    "quantity": 5,
                                    "shipDate": "2022-12-04T12:21:46.297+0000",
                                    "status": "placed",
                                    "complete": true
                                }
     */

@Test
    public void post01(){

   // set the URL
    spec.pathParams("first","store","second","order");

    // set the expectedData ==> we use two ways to do this, POJO class with object Mapper and Map

    Map<String,Object> expectedData = new HashMap<>();
    expectedData.put("petId",10);
    expectedData.put("quantity", 5);
    expectedData.put("shipDate","2022-12-04T12:21:46.297+0000");
    expectedData.put("status", "placed");
    expectedData.put( "complete", true);

    System.out.println("expecteData = " + expectedData);
    // send the request
    Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}/{second}");
    response.prettyPrint();

    //Do the assertion 
    Map<String,Object> actualData = response.as(HashMap.class);
    System.out.println("actualData = " + actualData);

    assertEquals(200,response.statusCode());
    assertEquals(expectedData.get("petId"),actualData.get("petId"));
    assertEquals(expectedData.get("quantity"),actualData.get("quantity"));
    assertEquals(expectedData.get("shipDate"),actualData.get("shipDate"));
    assertEquals(expectedData.get("status"),actualData.get("status"));
    assertEquals(expectedData.get("complete"),actualData.get("complete"));
}

}
