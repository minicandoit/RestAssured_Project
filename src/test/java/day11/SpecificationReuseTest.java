package day11;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import test_util.SpartanWithAuthBaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SpecificationReuseTest extends SpartanWithAuthBaseTest {


    // all test in this class class will use admin credentials
    // all tests in this class will expect json result from response

    // all tests in this class response status code expected to be 200
    // all tests in this class response content type header is json

    @DisplayName("Admin GET /spartans and expect 200 and json ")
    @Test
    public void testAdminGetAll(){

        RequestSpecification requestSpec = given()
                                            .auth().basic("admin", "admin")
                                            .accept(ContentType.JSON);

        ResponseSpecification responseSpec = expect()
                                                .statusCode(200)
                                                .contentType(ContentType.JSON);


        given()
                .spec(requestSpec).
        when()
                .get("/spartans").
        then()
                .spec(responseSpec)
                ;


//        given()
//                .auth().basic("admin","admin")
//                .accept(ContentType.JSON).
//        when()
//                .get("/spartans").
//        then()
//                .statusCode(200)
//                .contentType(ContentType.JSON) ;
    }

    @DisplayName("Admin GET /spartans/{id} and expect 200 and json , expect id match ")
    @Test
    public void testAdminGetOne(){

        given()
                .auth().basic("admin","admin")
                .accept(ContentType.JSON)
                .pathParam("id",1).
        when()
                .get("/spartans/{id}").
        then()
                .log().body()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", is(1))
        ;


    }




    }
