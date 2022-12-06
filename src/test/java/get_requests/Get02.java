package get_requests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class Get02 {
//Task : Print all "available" pets on console by using"https://petstore.swagger.io/" documentation.

//above is our task, first we nned to know what should we do, we go to Documentation.which here is "swagger". we go there
//and read all we need to do in "GET" ==> when you open in "status" part choose Available and execute then we find URL and all data
  // then take URL to postman and send the GET.
    /*      then write the task in Gorken Lnaguage with URL.
    https://petstore.swagger.io/v2/pet/findByStatus?status=available
When
    User sends Get Request to url
Then
     HTTP Status Code is 200
And
    print all "available" pets console
     */

@Test    // here we do not have this "dependency" so we need to copy from Maven Repository, add to pom.xml in dependencies
                            // we choose the latest one
    public void get02(){

    //set the url
    String url = " https://petstore.swagger.io/v2/pet/findByStatus?status=available";

    // Get the ecpecteData

    // senr req and get the res
    Response response = given().when().get(url);

    // Print All Available Pet on console
    response.prettyPrint();

    // Do Assertion
    response.then().assertThat().statusCode(200);
    System.out.println("statusCode");

}
}
