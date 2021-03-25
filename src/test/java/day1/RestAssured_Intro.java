package day1;

import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.* ;

@DisplayName("Intro to RestAssured")
public class RestAssured_Intro {

    @DisplayName("Testing hello endpoint")
    @Test
    public void testHelloEndpoint(){

        // GET http://18.235.32.166:8000/api/hello
        // Save the response into a object with type Response
       Response response = get("http://18.235.32.166:8000/api/hello");
       // extracting information from Response object
        // getting status code
        System.out.println("response.statusCode() = " + response.statusCode() );
        // getting specific header
        System.out.println("response.getHeader(\"Content-Type\") = "
                            + response.getHeader("Content-Type"));
        // getting body as String
        System.out.println("response.asString() = " + response.asString());
    }


}
