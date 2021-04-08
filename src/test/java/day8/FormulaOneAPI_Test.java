package day8;

import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.Driver;

public class FormulaOneAPI_Test {

    @BeforeAll
    public static void init(){

        baseURI = "http://ergast.com";
        basePath = "api/f1" ;

    }

    @DisplayName("GET /drivers.json and save result to pojo")
    @Test
    public void testDrivers(){

        // Get first Driver as Driver POJO
        JsonPath jp = get("/drivers.json").jsonPath() ;
        Driver d1 = jp.getObject("MRData.DriverTable.Drivers[0]", Driver.class) ;
        System.out.println("d1 = " + d1);

        // Get all drivers as List<Driver>



    }

    @AfterAll
    public static void cleanup(){
        reset();
    }




}
