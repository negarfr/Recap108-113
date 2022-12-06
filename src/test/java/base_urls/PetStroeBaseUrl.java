package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;

public class PetStroeBaseUrl {


    protected RequestSpecification spec ;

    @BeforeEach //JunitJupiter Annnotation
    public void setUp(){

        spec = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2/").build();
    }
}
