package day7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test_util.SpartanNoAuthBaseTest;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;

public class SpartanDeserialization_Test extends SpartanNoAuthBaseTest {

    // Serialization    : Java Object to Json (or any other type of text)
    // De-Serialization : Json(text) to Java

    @DisplayName("GET /spartans/{id}")
    @Test
    public void testGetOneData(){




    }


}
