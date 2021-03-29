package day3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.Spartan;
import test_util.SpartanNoAuthBaseTest;

import static io.restassured.RestAssured.given;

public class SpartanPost_NegativeTest extends SpartanNoAuthBaseTest {


    @DisplayName("Post request without content type expect 415")
    @Test
    public void test1(){

        Spartan sp = new Spartan("B21", "Male" , 1231231231L) ;
                given()
                        .log().body()
                        .body(sp).
                when()
                        .post("/spartans").
                then()
                        .statusCode(415) ;


    }

    @DisplayName("Post request without valid json expect 400")
    @Test
    public void test2(){

    }

    @DisplayName("Post request with valid json , bad name - expect 400 with detailed name error message")
    @Test
    public void test3(){

    }

    @DisplayName("Post request with bad name, phone - expect 400 with detailed name, phone error message")
    @Test
    public void test4(){

    }


    @DisplayName("Post request with bad name, phone , gender - expect 400 with 3 errors")
    @Test
    public void test5(){

    }

}
