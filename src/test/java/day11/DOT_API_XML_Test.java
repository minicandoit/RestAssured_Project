package day11 ;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.restassured.path.xml.XmlPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.*;

public class DOT_API_XML_Test {
    /*
    Send GET Request to https://vpic.nhtsa.dot.gov/api/vehicles/GetMakeForManufacturer/988?format=xml
    and verify the
    count element text is 2
    message Results returned successfully
    first Make_ID is  474 , Make_Name Honda
     */

    @DisplayName("XML Test with Vehicles API")
    @Test
    public void testHonda(){



    }




}
