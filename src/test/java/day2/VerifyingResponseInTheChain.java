package day2;


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


    }

}
