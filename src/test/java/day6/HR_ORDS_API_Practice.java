package day6;

import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HR_ORDS_API_Practice {

    //GET http://18.235.32.166:1000/ords/hr/api/regions
    // base_uri = http://18.235.32.166:1000
    // base_path =  /ords/hr/api
    // resources /regions

    @BeforeAll
    public static void init(){
        baseURI = "http://18.235.32.166:1000";
        basePath = "/ords/hr/api" ;
    }

    @DisplayName("GET /regions test")
    @Test
    public void testAllRegions(){

        //get("/regions").prettyPeek() ;


    }




    @AfterAll
    public static void cleanup(){
        reset();
    }



}
