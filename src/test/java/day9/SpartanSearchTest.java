package day9;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test_util.DB_Utility;
import test_util.SpartanNoAuthBaseTest;

public class SpartanSearchTest extends SpartanNoAuthBaseTest {

    @DisplayName("Test GET /spartans/search result with DB result")
    @Test
    public void testSearch(){

        // Search for nameContains a and gender Female
        // compare the count with DB result
        String query = "SELECT * FROM SPARTANS WHERE LOWER(NAME) LIKE '%a%' and GENDER = 'Female'" ;
        DB_Utility.runQuery(query) ;
//        DB_Utility.displayAllData();
        int expectedCount = DB_Utility.getRowCount()  ;
        System.out.println("count = " + expectedCount);





    }

}
