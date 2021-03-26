package day2;


import io.restassured.http.ContentType;
import test_util.SpartanNoAuthBaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import test_util.SpartanNoAuthBaseTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.* ;
import static org.hamcrest.Matchers.* ;

public class VerifyingResponseInTheChain extends SpartanNoAuthBaseTest {

    @DisplayName("Verifying the GET /spartans/{id} response directly in the chain")
    @Test
    public void testOneSpartanInOneShot(){


        given()
//                .log().all()
//                .log().ifValidationFails() // this will log the request
                .pathParam("id",16).
        when()
                .get("/spartans/{id}").
        then()
//                .log().all() // this will log the response
//                .log().body()
//                .log().ifValidationFails()
//                .log().status()
//                .log().headers()
//                .log().ifError() // anything not 2xx status is seen as error for this method
//                .log().ifStatusCodeIsEqualTo(200)
                .statusCode(200)
                .header("Content-Type", is("application/json") )
                .contentType("application/json")
                .body("id", equalTo(16) )
                .body("name" , is("Wonder Woman") )
                .body("gender" , is("Female") )
                .body("phone" , equalTo(9234567890L))

        ;


    }

}
