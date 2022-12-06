package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;

public class AutomationExcerciseBaseUrl {

    protected RequestSpecification spec ;

    @BeforeEach //JunitJupiter Annnotation
    public void setUp(){

        spec = new RequestSpecBuilder().setBaseUri( "https://automationexercise.com/api/").build();
    }
}
