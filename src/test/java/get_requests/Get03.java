package get_requests;

import base_urls.PetStroeBaseUrl;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class Get03 extends PetStroeBaseUrl {
/*
    Print all "available" pets on console by using"https://petstore.swagger.io/" documentation.
    There should be more than 30 "available" pets, "fish" and "doggie" pet names must exist.
    */
    /*
Given
    https://petstore.swagger.io/v2/pet/findByStatus?status=available
When
    User sends Get request to the Url
Then
    HTTP Status Code is 200

And
    "fish" and "doggie" pet names must exist between pets.

And
    There should be more than 30 "available" pets
 */

   @Test
   public void get03(){

    spec.pathParams("first","pet","second","findByStatus").queryParams("status","available");

    // send the Req and GET the Res
       Response response = given().spec(spec).when().get("/{first}/{second}") ;
       response.prettyPrint();

   // Do assertion
   // "fish" and "doggie" pet names must exist between pets.
  //  There should be more than 30 "available" pets


       response.then().assertThat().statusCode(200).body("name", hasItems("fish", "doggie"),
              "id",hasSize(greaterThan(30)));








}




}
