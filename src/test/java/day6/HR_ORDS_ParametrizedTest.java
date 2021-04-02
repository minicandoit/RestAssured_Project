package day6;

import static io.restassured.RestAssured.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import test_util.HR_ORDS_API_BaseTest;

public class HR_ORDS_ParametrizedTest extends HR_ORDS_API_BaseTest {

    //GET http://18.235.32.166:1000/ords/hr/api/regions
    // base_uri = http://18.235.32.166:1000
    // base_path =  /ords/hr/api
    // resources /countries/{country_id}

   @Test
   public void testCountries(){

//       get("/countries").prettyPeek();
       get("/countries/AR").prettyPeek();
   }

   @ParameterizedTest
   @ValueSource(strings = {"AR", "AU" ,"US"}     )
   public void testSingleCountryWithValues( String countryIdArg ){

       // GET /countries/{country_id}
       given()
               .log().uri()
               .pathParam("country_id", countryIdArg).
       when()
               .get("/countries/{country_id}").
       then()
               .log().body()
               .statusCode(200);

   }


}
