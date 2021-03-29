package day3;

import test_util.SpartanNoAuthBaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import test_util.SpartanNoAuthBaseTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.* ;
import static org.hamcrest.Matchers.* ;

public class SpartanJsonPath_Test extends SpartanNoAuthBaseTest {

    //http://YourKitchenIp:8000/api/spartans/160

    @Test
    public void testOne(){

        Response response =
                given()
                        .pathParam("id","160").
                when()
                        .get("/spartans/{id}")
                        .prettyPeek() ;


    }


}
