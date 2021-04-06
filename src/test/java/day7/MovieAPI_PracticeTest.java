package day7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.Movie;
import static io.restassured.RestAssured.*;
public class MovieAPI_PracticeTest {


    // save the result of your request
    // SEND GET http://www.omdbapi.com/?t=Avenger&apikey=YOUR OWN API KEY goes here

    // save the response into Movie POJO , title Str, year int , Released str ,Language
    // ignore any unknown properties
    // match the json fields to pojo fields
    @DisplayName("GET GET http://www.omdbapi.com/?t=Avenger&apikey=YOUR OWN API KEY")
    @Test
    public void testMovieToPOJO(){

        Movie m1 =  given()
                        .baseUri("http://www.omdbapi.com")
                        .queryParam("apikey","5b5d0fe8")
                        .queryParam("t","Superman").
                    when()
                        .get()
//                        .jsonPath()
//                        .getObject("",Movie.class)
                        .as(Movie.class)
                ;
        System.out.println("m1 = " + m1);

    }

    @DisplayName("GET Search for avenger and save Ratings field into List<Rating>")
    @Test
    public void testMovieRatingToPOJO(){



    }

}
