package day9;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test_util.SpartanWithAuthBaseTest;

public class SpartanWithAuthTest extends SpartanWithAuthBaseTest {


    @DisplayName("GET /spartans as public user expect 401")
    @Test
    public void testPublicUser(){

    }

    @DisplayName("GET /spartans as admin user expect 200")
    @Test
    public void testAdmin(){

    }


    @DisplayName("DELETE /spartans/{id} as editor user expect 403")
    @Test
    public void testEditor(){

    }





}
