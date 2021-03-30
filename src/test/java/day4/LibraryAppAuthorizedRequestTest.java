package day4;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import test_util.LibraryAppBaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LibraryAppAuthorizedRequestTest extends LibraryAppBaseTest {



    @DisplayName("GET /get_user_by_id/{user_id}")
    @Test
    public void testOneUser(){


        System.out.println("myToken = " + librarianToken);

        //we are sending request to this endpoint  : GET /get_user_by_id/1
        given()
                .log().all()
                .header("x-library-token", librarianToken)
                .pathParam("user_id", 1).
        when()
            .get("/get_user_by_id/{user_id}").
        then()
                .log().all()
                .statusCode(200)
        ;
    }

    @DisplayName("GET /get_all_users")
    @Test
    public void testGetAllUsers(){

        System.out.println("myToken = " + librarianToken);


        List<String> allNames =
                given()
                        .header("x-library-token", librarianToken).
                when()
                        .get("/get_all_users").
                then()
                        //.log().all()
                        .statusCode(200).
                    extract()
                        // extracting jsonpath so we can call getList method
                        .jsonPath()
                        .getList("name", String.class)
        ;
        // assert the size is 8465
        assertThat(allNames, hasSize(8665));
        // print the unique names count
        Set<String> uniqueNames = new HashSet<>( allNames ) ;
        System.out.println("uniqueNames.size() = " + uniqueNames.size() );


    }


    @DisplayName("POST /add_book")
    @Test
    public void testAddOneBook(){
/*
    name Awesome book
    isbn IMDBS132
    year 2019
    author Ike
    book_category_id 2
    description good book
 */


        given()
                .log().all()
                .header("x-library-token", librarianToken)
                .contentType(ContentType.URLENC)
                // using formParams with s we can pass multiple param in one shot
                .formParams(  getRandomBook()  ).
        when()
                .post("/add_book").
        then()
                .log().all()
                .statusCode(200)
            ;

    }




}
