package day11 ;

import org.junit.jupiter.api.*;
import io.restassured.path.xml.XmlPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.*;

public class DOT_API_XML_Test {
    /*
    Send GET Request to https://vpic.nhtsa.dot.gov/api/vehicles/GetMakeForManufacturer/988?format=xml
    and verify the
    count element text is 2
    message Results returned successfully
    first Make_ID is  474 , Make_Name Honda
     */

    @BeforeAll
    public static void init(){
        baseURI = "https://vpic.nhtsa.dot.gov" ;
        basePath = "/api/vehicles" ;
    }
    @AfterAll
    public static void cleanup(){
        reset();
    }

    @DisplayName("XML Test with Vehicles API GET /GetMakeForManufacturer/988?format=xml")
    @Test
    public void testHonda(){
         // what we did yesterday without checking status code
        /*
        XmlPath xp =
        given()
                .queryParam("format","xml").
        when()
                .get("/GetMakeForManufacturer/988")
                .xmlPath();
         */

        // check status code then extract xmlPath
        XmlPath xp =
        given()
                .queryParam("format","xml").
        when()
                .get("/GetMakeForManufacturer/988").
        then()
                .statusCode(200)
                .log().body().
            extract()
                .xmlPath()
                ;

//        count element text is 2
        int countElementText =  xp.getInt("Response.Count") ;
        System.out.println("countElementText = " + countElementText);

//    message Results returned successfully
        String message = xp.getString("Response.Message") ;
        System.out.println("message = " + message);
//    first Make_ID is  474 , Make_Name Honda




    }




}
