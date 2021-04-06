package day7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.Country;
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

    @DisplayName("GET /Countries")
    @Test
    public void testAllCountries(){

//        Country c1 = new Country("AR","Argentina", 1) ;
//        System.out.println("c1 = " + c1);

        // Save 3rd country as Country POJO
        Country thirdCountry = get("/countries").jsonPath()
                .getObject("items[2]", Country.class) ;
        System.out.println("thirdCountry = " + thirdCountry);


        // Save all countries as List<POJO>
        List<Country> allCountries = get("/countries").jsonPath()
                                    .getList("items", Country.class) ;

        allCountries.forEach(p-> System.out.println(p) );




    }


}
