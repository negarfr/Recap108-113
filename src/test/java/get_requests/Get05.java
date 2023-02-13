package get_requests;

import base_urls.AutomationExcerciseBaseUrl;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Get05 extends AutomationExcerciseBaseUrl {
      /*
        Given
	   	    https://automationexercise.com/api/productsList
		When
			 I send GET Request to the URL
		Then
			 1)Status code is 200
			 2)Print all ids greater than 30 on the console
			   Assert that there are 10 ids greater than 30
			 3)Print all brands whose usertype is Women on the console
			   Assert that the number of brands whose usertype is Women is 12
			 4)Total price of all product is 41864
     */

    @Test
    public void get05() {
        //Set the url
        spec.pathParam("first", "productsList");

        //Set the expected data

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}");
        response.jsonPath().prettyPrint();

        //Do assertion
        //1)Status code is 200
        assertEquals(200,response.statusCode());

        // 2)Print all ids greater than 30 on the console
        //   Assert that there are 10 ids greater than 30
        List<Integer> ids = response.jsonPath().getList("products.findAll{it.id>30}.id");//Groovy
        System.out.println("ids = " + ids);
        assertEquals(10, ids.size());

        //	 3)Print all brands whose usertype is Women on the console
        //	 Assert that the number of brands whose usertype is Women is 12

        List<String> brands = response.jsonPath().getList("products.findAll{it.category.usertype.usertype=='Women'}.brand");
        System.out.println("brands = " + brands);
        assertEquals(12,brands.size());

        //4)Total price of all product is 41864
        
       List<String> prices =  response.jsonPath().getList("products.price"); //All prices are in list in response body
        System.out.println("prices = " + prices);

        int totalPrice =0;
        for (String w:prices){

            totalPrice += Integer.parseInt(w.replaceAll("[^0-9]", ""));  //replaceAll all the characters are diff from Integer
        }                       // convert the string to Integer
        System.out.println("totalPrice = " + totalPrice);

        assertEquals(41864,totalPrice);

        //2nd Way : LAMBDA
       int totalPriceLambda=  prices.stream().map(t-> Integer.parseInt(t.replaceAll("[^0-9]", ""))).reduce(0,Math::addExact);
                  // using map to change the data in Lambda
        System.out.println("totalPriceLambda = " + totalPriceLambda);
         assertEquals(41864,totalPriceLambda);


    }
}