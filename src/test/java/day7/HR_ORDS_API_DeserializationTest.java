package day7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.Region;
import test_util.HR_ORDS_API_BaseTest;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HR_ORDS_API_DeserializationTest extends HR_ORDS_API_BaseTest {


    // Send request to /regions and save the result into List<Region>
    // assert the list has size 4
    @DisplayName("GET /regions")
    @Test
    public void testGetAllRegionAndSaveToListOfPOJO(){

        // saving json array into List<Region>
        List<Region> allRegions =
                        get("/regions")
                        .jsonPath()
                        .getList("items" , Region.class) ;

        System.out.println("allRegions = " + allRegions);

    }


}
