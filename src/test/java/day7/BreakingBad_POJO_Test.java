package day7;

import static io.restassured.RestAssured.*;
import org.junit.jupiter.api.*;

public class BreakingBad_POJO_Test {

    @BeforeAll
    public static void init() {
        baseURI = "https://www.breakingbadapi.com";
        basePath = "/api";
    }
    @AfterAll
    public static void cleanup() {
        reset();
    }

    //https://www.breakingbadapi.com/api/characters
    @DisplayName("GET /characters")
    @Test
    public void testPracticeDeserialization(){

        // Send request to GET https://www.breakingbadapi.com/api/characters
        // save first item into Character pojo
        // save all items into List<Character>
        // print all character name who appeared exactly 5 times  --- check appearance list size

    }

}
