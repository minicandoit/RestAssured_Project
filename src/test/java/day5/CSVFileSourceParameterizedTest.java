package day5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class CSVFileSourceParameterizedTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/state_city_zipCount.csv" , numLinesToSkip = 1 )
    public void testStateCityToZipEndpointWithCSVFile(String stateArg, String cityArg , int zipArg  ){

        System.out.println("stateArg = " + stateArg);
        System.out.println("cityArg = " + cityArg);
        System.out.println("zipArg = " + zipArg);

    }


}
