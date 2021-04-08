package day8;

import org.junit.jupiter.api.Test;
import test_util.DB_Utility;
import test_util.HR_ORDS_API_BaseTest;

import java.util.List;

import static io.restassured.RestAssured.*;

public class HR_ORDS_API_DB_Test extends HR_ORDS_API_BaseTest {

    // We added DB Connection and DB Destroy method into base test
    // We added the base uri of HR ORDS API into configuration file

    @Test
    public void testHR_ORDS_API(){

        DB_Utility.runQuery("SELECT * FROM REGIONS") ;
        DB_Utility.displayAllData();

    }


}
