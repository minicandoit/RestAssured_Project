package day11;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test_util.LibraryAppBaseTest;

import static io.restassured.RestAssured.given;

public class ReusableSpecLibraryAppTest extends LibraryAppBaseTest {


    @DisplayName("GET /dashboard_stats")
    @Test
    public void testDashboardStats(){

        given()
                .spec(librarianSpec).
        when()
                .get("/dashboard_stats")
        .then()
//                .statusCode(200)
//                .log().body()
             .spec(libraryResponseSpec)
        ;
    }

    @DisplayName("GET /get_all_users")
    @Test
    public void testGetAllUser(){

        given()
                .spec(librarianSpec).
        when()
                .get("/get_all_users").
        then()
                .spec(libraryResponseSpec)
                ;
        // in class task
        // use the Reusable request specification
        // we build to send the request to get all users

        // build reusable Response specification
        //  status code of 200
        //  content type of json
        //  and log all
        // Add it to the BaseTest

        // try reusing it in both of the tests in this class



    }




}
