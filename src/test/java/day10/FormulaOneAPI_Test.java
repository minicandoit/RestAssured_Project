package day10;

import io.restassured.path.xml.XmlPath;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class FormulaOneAPI_Test {

    @BeforeAll
    public static void init(){
        baseURI = "http://ergast.com";
        basePath = "/api/f1/";
    }

    @DisplayName("Test GET /drivers/{driver_id}")
    @Test
    public void testDriverOne(){

        // send request to get information of driver_id alonso and save  xml result and assert or assert in the chain
        XmlPath xp = given()
                        .pathParam("driver_id","alonso").
                     when()
                        .get("/drivers/{driver_id}")
                        .xmlPath() ;

        String givenName =  xp.getString("MRData.DriverTable.Driver.GivenName") ;
        System.out.println("givenName = " + givenName);
        String familyName =  xp.getString("MRData.DriverTable.Driver.FamilyName") ;
        System.out.println("familyName = " + familyName);


    }


    @AfterAll
    public static void cleanup(){
        reset();
    }


}
