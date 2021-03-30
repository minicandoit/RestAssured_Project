package day4;

import test_util.LibraryAppBaseTest;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class LibraryAppAuthorizedRequestTest extends LibraryAppBaseTest {


    @DisplayName("GET /get_user_by_id/{user_id}")
    @Test
    public void testOneUser(){




    }



}
