package test_util;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public abstract class SpartanNoAuthBaseTest {

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


}
