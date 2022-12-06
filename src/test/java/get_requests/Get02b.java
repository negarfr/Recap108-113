package get_requests;

import base_urls.PetStroeBaseUrl;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Get02b extends PetStroeBaseUrl {
    //Print all "available" pets on console by using"https://petstore.swagger.io/" documentation.


    /*
    https://petstore.swagger.io/v2/pet/findByStatus?status=available
When
    User sends Get Request to url
Then
     HTTP Status Code is 200
And
    print all "available" pets console
     */

@Test
    public void get02(){

    //set the url
   spec.pathParams("first","pet","second","findByStatus").queryParams("status","available");

    // Get the ecpecteData

    // senr req and get the res
    Response response = given().spec(spec).when().get("/{first}/{second}");

    // Print All Available Pet on console
    response.prettyPrint();

    // Do Assertion
    response.then().assertThat().statusCode(200);
    System.out.println("statusCode");

}
}
