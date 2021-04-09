package day9;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import test_util.DB_Utility;
import test_util.HR_ORDS_API_BaseTest;

import java.util.List;
import java.util.Map;

public class HR_Homework_Test extends HR_ORDS_API_BaseTest {

    /*
    // HOMEWORK : RUN QUERY  runQuery("SELECT * FROM REGIONS") save result as List of Map
    // Write a method to return above List of Map called getAllRegionListOfMap
    // Write a parameterized Test for GET /regions/{region_id}
    // Use getAllRegionListOfMap method as Method Source for your Parameterized Test
     */

    @ParameterizedTest
    @MethodSource("getAllRegionListOfMap")
    public void testAllRegions( Map<String,String> rowMapArg  ){

        System.out.println("rowMapArg = " + rowMapArg);

    }



    public static List<Map<String,String>> getAllRegionListOfMap(){

        DB_Utility.runQuery("SELECT * FROM REGIONS") ;
        return DB_Utility.getAllRowAsListOfMap() ;

    }


}
