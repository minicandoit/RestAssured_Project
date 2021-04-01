package day5;

import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.* ;
import static org.hamcrest.Matchers.* ;
public class MovieAPI_Practice {


    @DisplayName("Search movies JsonPath practice")
    @Test
    public void testSearch(){

        //GET http://www.omdbapi.com?s=Superman&type=series&Your_API_KEY_GOES_HERE

        // if you do not have other place you are using it ,
        // you directly provide your baseURI using baseURI method in given

        JsonPath jp =
            given()
                    .baseUri("http://www.omdbapi.com")
                    .log().all()
                    .queryParam("apikey" ,  "YOUR OWN KEY")
                    .queryParam("s" , "Superman")
                    .queryParam("type","series").
            when()
                    .get().
            then()
                    .log().all()
                    .statusCode(200)
                    // CONTINUE from here save Titles as list
                .extract()
                    .jsonPath()
        ;
        List<String> allTitles = jp.getList("Search.Title") ;
        System.out.println("allTitles = " + allTitles);






    }


}
