package day11;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pojo.Spartan;
import spartan_util.SpartanUtil;
import test_util.SpartanNoAuthBaseTest;
import test_util.SpartanWithAuthBaseTest;

import java.io.File;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class SpartanPostSchemaTest extends SpartanWithAuthBaseTest {

    @DisplayName("Test Json Schema for Post Response")
    @Test
    public void testAdd1SpartanResponse(){

        Spartan bodyPOJO = SpartanUtil.getRandomSpartanPOJO() ;
        System.out.println("bodyPOJO = " + bodyPOJO);

        given()
               .auth().basic("admin","admin")
               .contentType(ContentType.JSON)
               .body(bodyPOJO).
        when()
                .post("/spartans").
        then()
                .statusCode(201)
                .log().all()
                .body(matchesJsonSchemaInClasspath("spartanPostJsonSchema.json") ) ;


    }


}
