package day6;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
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
        // log the request uri
        // send GET /regions request
        // log the response
        // test status code is 200
        // test the count is 4
        // also test the size of items json array is 4
        given()
                .log().uri().
        when()
                .get("/regions").
        then()
                .log().all()
                .statusCode(200)
                .body("count", equalTo(4))
                .body("items", hasSize(4) )

        ;

    }




    @AfterAll
    public static void cleanup(){
        reset();
    }



}
