package day9;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test_util.LibraryAppBaseTest;

import java.util.Map;

import static io.restassured.RestAssured.*;

public class Library_API_DB_Post_Test extends LibraryAppBaseTest {


    // Add a random book using POST /add_book
    // grab the id  and write a query to book information with this id
    // assert ALL data match exactly as it was posted.

    @DisplayName("Add One book ,Validate from DB")
    @Test
    public void testAddBookPersisted(){

        Map<String,Object> randomBookMapBody = getRandomBook() ;
        System.out.println("randomBookMapBody = " + randomBookMapBody);

        int newBookId =  given()
                                .header("X-LIBRARY-TOKEN" , librarianToken)
                                .contentType(ContentType.URLENC)
                                .formParams(randomBookMapBody).
                         when()
                                .post("/add_book").
                         then()
                                // normally it return 201 , this one decided to return 200
                                .statusCode(200)
                                .log().body()
                            .extract()
                                .jsonPath().getInt("book_id") ;
        System.out.println("newBookId = " + newBookId);
    }



}
