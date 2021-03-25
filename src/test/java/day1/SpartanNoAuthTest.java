package day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.* ;
import static org.hamcrest.Matchers.* ;

@DisplayName("Spartan App Get Requests")
public class SpartanNoAuthTest {

    //http://18.235.32.166:8000/api/hello
    //http://18.235.32.166:8000/api/spartans

    @BeforeAll
    public static void init(){
        // this will set the part of URL at RestAssured
        RestAssured.baseURI     = "http://18.235.32.166:8000"  ;
//        RestAssured.port = 8000 ;
        RestAssured.basePath    = "/api" ;
    }

    @AfterAll
    public static void cleanup(){
        RestAssured.reset();
    }


    @Test
    public void sayHello(){
        // the actual request url you have sent is this
        // baseURI + basePath + "/hello"
        get("/hello").prettyPeek();
    }

    @Test
    public void getAllSpartans(){
        // the actual request url you have sent is this
        // baseURI + basePath + "/spartans"
        get("/spartans").prettyPeek() ;




    }




}
