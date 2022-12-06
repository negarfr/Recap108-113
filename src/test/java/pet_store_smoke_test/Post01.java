package pet_store_smoke_test;

import base_urls.PetStroeBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import pojos.Category;
import pojos.PetStorePet;
import pojos.Tags;

import java.util.ArrayList;

import static io.restassured.RestAssured.*;

public class Post01 extends PetStroeBaseUrl {
    /*
    Given
        https://petstore.swagger.io/v2/pet
    And
                    {
                      "id": 1234321,
                      "category": {
                        "id": 0,
                        "name": "Cat"
                      },
                      "name": "Pamuk",
                      "photoUrls": [
                        "string"
                      ],
                      "tags": [
                        {
                          "id": 0,
                          "name": "My cute cat"
                        }
                      ],
                      "status": "available"
                    }
    `When
        User sends Post request
    Then
        Http Status code is 200
     And
       Response body is like: {
`                               "id": 1234321,
                                "category": {
                                    "id": 0,
                                    "name":"Cat"
                                },
                                "name": "Pamuk",
                                "photoUrls": [
                                    "string"
                                ],
                                "tags": [
                                    {
                                        "id": 0,
                                        "name": "My cute cat"
                                    }
                                                ],
                                                "status": "available"
                                            }

 */
@Test
    public void post01(){
    // set the url
    spec.pathParam("first","pet");
    // se the expectedData
    Category category = new Category(0,"Cat");
    Tags tags = new Tags(0,"My cute cat");
    ArrayList<String > arrayList = new ArrayList<>();
    arrayList.add("string");
    ArrayList<Tags> arrayListTags = new ArrayList<>();
    arrayListTags.add(tags);

    PetStorePet expectedData= new PetStorePet(1234321,category,"Pumak",arrayList,arrayListTags,"available");
    System.out.println("expectedData=" + expectedData);
    //send the request and get the response
    Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
    response.prettyPrint();




}





}
