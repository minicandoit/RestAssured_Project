package day3;
import io.restassured.path.json.JsonPath;
import test_util.SpartanNoAuthBaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import test_util.SpartanNoAuthBaseTest;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.* ;
import static org.hamcrest.Matchers.* ;

@DisplayName("Testing adding data to Spartan app multiple way")
public class SpartanPostingData_Test extends SpartanNoAuthBaseTest{

    @DisplayName("POST /spartans with String")
    @Test
    public void testPostDataWithStringBody(){





    }





}
