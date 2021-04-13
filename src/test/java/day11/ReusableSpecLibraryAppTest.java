package day11;

import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test_util.LibraryAppBaseTest;

import static io.restassured.RestAssured.given;

public class ReusableSpecLibraryAppTest extends LibraryAppBaseTest {


    @DisplayName("GET /dashboard_stats")
    @Test
    public void testDashboardStats(){

        RequestSpecification librarianSpec = given()
                                .header("x-library-token",librarianToken) ;



        given()
                .spec(librarianSpec).
        when()
                .get("/dashboard_stats")
        .then()
                .statusCode(200)
        ;


    }



}
