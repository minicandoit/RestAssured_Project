package day8;

import org.junit.jupiter.api.Test;
import pojo.Region;
import test_util.DB_Utility;
import test_util.HR_ORDS_API_BaseTest;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static test_util.DB_Utility.*;

public class HR_ORDS_API_DB_Test extends HR_ORDS_API_BaseTest {

    // We added DB Connection and DB Destroy method into base test
    // We added the base uri of HR ORDS API into configuration file

    @Test
    public void testHR_ORDS_API(){

        runQuery("SELECT * FROM REGIONS WHERE REGION_ID = 1") ;
        displayAllData();
        // send request to GET /regions/{region_id} and compare the result with DB result

        // save expected data for region_id of 1 into List
        List<String> firstRowAsExpectedList = getRowDataAsList(1) ;
        System.out.println("firstRowAsExpectedList = " + firstRowAsExpectedList);
        // send API request to GET /regions/{region_id} with id of 1 , save the result into POJO
        Region r1 = given()
                        .pathParam("region_id",1).
                     when()
                         .get("/regions/{region_id}")
                        .jsonPath()
                        .getObject("items[0]", Region.class) ;
        System.out.println("r1 = " + r1);

        //get("/regions/{region_id}" , 1)
        // compare the result







    }


}
