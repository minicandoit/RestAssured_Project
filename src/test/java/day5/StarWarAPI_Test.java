package day5;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import pojo.Spartan;
import spartan_util.SpartanUtil;
import test_util.SpartanNoAuthBaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import test_util.SpartanNoAuthBaseTest;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.* ;
import static org.hamcrest.Matchers.* ;

public class StarWarAPI_Test {

    /*
    Interview Questions :
    Send request to  GET https://swapi.dev/api/people/
    Find out average height of all people showed up in the response
     */
    @BeforeAll
    public static void init(){
        baseURI = "https://swapi.dev";
        basePath = "/api" ;
    }


    @AfterAll
    public static void cleanup(){
        reset();
    }




}
