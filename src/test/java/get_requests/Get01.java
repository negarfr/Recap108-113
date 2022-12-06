package get_requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Get01 {
     /*
   Given                                   // in this example we learn how to get *Rest Assured Liberary* and use it//
       https://petstore.swagger.io/v2/pet/12      //in here we copied from Maven Repsitory but when we work in Company
   When                                           // we must get our "Dependencies" From the own COMPANY
       User sends a GET Request to the url
   Then
       HTTP Status Code should be 200
   And
       Content Type should be JSON
   And
       Status Line should be HTTP/1.1 200 OK
*/

    public static void main(String[] args) {
        // set the URL
    String url= " https://petstore.swagger.io/v2/pet/12";

        // set the ExpectedData

        //Send the request and get the response
    Response response = given().when().get(url);
    response.prettyPrint();


        //Do Assertion

        // HTTP Status Code should be 200
        if (response.statusCode() == 200) {
            System.out.println("Test Passed: Status Code is 200");
        } else {
            System.out.println("Test Failed: Status code " + response.statusCode());
        }

        //Content Type should be JSON
        if (response.contentType().equals("application/json")) {
            System.out.println("Test Passed: Content Type is application/json");

        } else {
            System.out.println("Test Failed:  Content Type is " + response.contentType());
        }


        //Status Line should be HTTP/1.1 200 OK
        if (response.statusLine().equals("HTTP/1.1 200 OK")) {
            System.out.println("Test Passed: Status Line is HTTP/1.1 200 OK");

        }else {
            System.out.println("Test Failed:  Status Line is " + response.statusLine());
        }
    }


}










