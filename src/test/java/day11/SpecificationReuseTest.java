package day11;

import test_util.SpartanWithAuthBaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SpecificationReuseTest extends SpartanWithAuthBaseTest {


    // all test in this class class will use admin credentials
    // all tests in this class will expect json result from response

    // all tests in this class response status code expected to be 200
    // all tests in this class response content type header is json

    @DisplayName("Admin GET /spartans and expect 200 and json ")
    @Test
    public void testAdminGetAll(){


    }



}
