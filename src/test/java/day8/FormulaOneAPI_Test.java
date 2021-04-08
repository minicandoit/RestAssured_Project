package day8;

import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FormulaOneAPI_Test {

    @BeforeAll
    public static void init(){

        baseURI = "http://ergast.com";
        basePath = "api/f1" ;

    }

    @DisplayName("GET /drivers.json and save result to pojo")
    @Test
    public void testDrivers(){



    }

    @AfterAll
    public static void cleanup(){
        reset();
    }




}
