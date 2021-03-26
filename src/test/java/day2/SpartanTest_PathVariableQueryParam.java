package day2;

import test_util.SpartanNoAuthBaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import test_util.SpartanNoAuthBaseTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.* ;
import static org.hamcrest.Matchers.* ;

@DisplayName("Spartan Test with path variable and quert param")
public class SpartanTest_PathVariableQueryParam extends SpartanNoAuthBaseTest {

    @Test
    public void getOneSpartan(){

        //get("/spartans/16").prettyPeek();

        // I want to provide 16 as path variable|parameter
        // I want to provide accept header

        Response r1 =
                given()
                        .header("Accept", "application/json")
                        .pathParam("spartan_id",16).
                when()
                        .get("/spartans/{spartan_id}")
                        .prettyPeek()
                ;

        Response r2 =
                given()
                        // this is same as .header("Accept", "application/json")
                        .accept("application/json").
                when()
                        // This is alternative way of providing
                        // path variable and value directly in get method
                        .get("/spartans/{spartan_id}" , 16 )
                        .prettyPeek() ;
    }



}
