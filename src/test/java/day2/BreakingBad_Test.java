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

public class BreakingBad_Test {

    //https://www.breakingbadapi.com/api/characters?name=Walter
    @BeforeAll
    public static void init(){
        baseURI     = "https://www.breakingbadapi.com";
        basePath    = "/api" ;
    }
    @AfterAll
    public static void cleanup(){
        reset();
    }

    @Test
    public void testFilterCharacterName(){

        given()
                .log().uri()
                .queryParam("name", "Walter").
        when()
                .get("/characters").
        then()
//                .assertThat() // this is coming from restassured, it's just for readability
                .log().all()
                //and() // this is just for readability
                .statusCode(200)
                .header("Content-Type","application/json; charset=utf-8")
                .contentType("application/json; charset=utf-8")
                ;

    }




}
