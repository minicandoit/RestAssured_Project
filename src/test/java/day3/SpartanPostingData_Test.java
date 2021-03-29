package day3;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import test_util.SpartanNoAuthBaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import test_util.SpartanNoAuthBaseTest;

import java.io.File;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.* ;
import static org.hamcrest.Matchers.* ;

@DisplayName("Testing adding data to Spartan app multiple way")
public class SpartanPostingData_Test extends SpartanNoAuthBaseTest{

    @DisplayName("POST /spartans with String")
    @Test
    public void testPostDataWithStringBody(){

        /*
           {
                "name" : "Abigale",
                "gender" : "Female",
                "phone" : 1800233232
            }
         */
        String postStrBody = "{\n" +
                "                \"name\" : \"Abigale\",\n" +
                "                \"gender\" : \"Female\",\n" +
                "                \"phone\" : 1800233232\n" +
                "            }" ;

        given()
                .log().all()
//                .header("Content-Type", "application/json")
//                .contentType("application/json")
                .contentType( ContentType.JSON) // this is providing header for request
                .body(postStrBody).
        when()
                .post("/spartans").
        then()
                .log().all()
                .statusCode( is(201) )
                .contentType(ContentType.JSON)// this is asserting response header is json
                .body("success" , is("A Spartan is Born!")  )
                .body("data.name", is("Abigale") )
        ;

    }

    @DisplayName("POST /spartans with external file")
    @Test
    public void testPostDataWithJsonFileAsBody(){

        // singleSpartan.json with below content
        /*
           {
                "name" : "Abigale",
                "gender" : "Female",
                "phone" : 1800233232
            }
         */
        File jsonFile = new File("singleSpartan.json");

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(jsonFile).
        when()
                .post("/spartans").
        then()
                .log().all()
                .statusCode(201)
                ;


    }

    @DisplayName("POST /spartans with Map Object")
    @Test
    public void testPostDataWithMapObjectAsBody(){




    }






}
