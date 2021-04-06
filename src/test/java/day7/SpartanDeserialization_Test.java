package day7;

import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.SpartanPOJO;
import test_util.SpartanNoAuthBaseTest;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;

public class SpartanDeserialization_Test extends SpartanNoAuthBaseTest {

    // Serialization    : Java Object to Json (or any other type of text|byteStream)
    // De-Serialization : Json(text | byteStream) to Java

    @DisplayName("GET /spartans/{id}")
    @Test
    public void testGetOneData(){

        given()
                .pathParam("id", 8001).
        when()
                .get("/spartans/{id}").
        then()
                .statusCode(200)
                .log().body() ;

    // Send same request , store the result into SpartanPOJO object

        Response response = given()
                            .pathParam("id", 8001).
                            when()
                            .get("/spartans/{id}") ;

        SpartanPOJO sp = response.as(SpartanPOJO.class) ;
        System.out.println("sp = " + sp);

        JsonPath jp = response.jsonPath();
        SpartanPOJO sp1 = jp.getObject("",SpartanPOJO.class) ;
        System.out.println("sp1 = " + sp1);


    }

    @DisplayName("GET /spartans/search")
    @Test
    public void testSearch(){

        ///spartans/search?nameContains=a&gender=Male
        // send get request to above endpoint and save first object with type SpartanPOJO

        Response response =
                given()
                        .log().uri()
                        .queryParam("nameContains", "a")
                        .queryParam("gender", "Male").
                when()
                        .get("/spartans/search").prettyPeek() ;

    }



}
