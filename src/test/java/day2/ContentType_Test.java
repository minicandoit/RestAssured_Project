package day2;

import test_util.SpartanNoAuthBaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import test_util.SpartanNoAuthBaseTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.* ;
import static org.hamcrest.Matchers.* ;

@DisplayName("Spartan ContentType Summary")
public class ContentType_Test extends SpartanNoAuthBaseTest {

    @DisplayName("GET /hello")
    @Test
    public void testHelloConetentType(){

    }

    @DisplayName("GET /spartans in json")
    @Test
    public void testSpartansJsonConetentType(){

    }
    @DisplayName("GET /spartans in xml")
    public void testSpartansXmlConetentType(){

    }
}
