package day3;

import io.restassured.path.json.JsonPath;
import test_util.SpartanNoAuthBaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import test_util.SpartanNoAuthBaseTest;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.* ;
import static org.hamcrest.Matchers.* ;

public class SpartanJsonPath_Test extends SpartanNoAuthBaseTest{

    //http://YourKitchenIp:8000/api/spartans/160

    @Test
    public void testOne(){

        Response response =
                given()
                        .log().all()
                        .pathParam("id","160").
                when()
                        .get("/spartans/{id}")
                        .prettyPeek() ;

        // using path method to extract data
        int myId = response.path("id") ;
        System.out.println("myId = " + myId);

        // Few meaning of JsonPath :
            //1. just like xpath -- it is used to provide location of certain data
            //2. JsonPath as a class coming from RestAssured to provide reusable methods to extract data
            //3. jsonPath() method of Response object to get JsonPath object
        JsonPath jp = response.jsonPath() ;  // number 2 for variable type , number 3 for method

        myId =   jp.getInt("id") ;
        System.out.println(" the result is = " + myId);

        long phoneNum =  jp.getLong("phone") ;
        System.out.println("phoneNum = " + phoneNum);

        String myName = jp.getString("name") ;
        System.out.println("myName = " + myName);


        System.out.println("Save whole json object into map = "
                + jp.getMap(""));

        Map<String, Object> resultJsonInMap = jp.getMap("") ;
        System.out.println("resultJsonInMap = " + resultJsonInMap);


    }

    @DisplayName("Extract data from GET /spartans ")
    @Test
    public void testGetAllSpartans(){

//        Response response = get("/spartans");
//        JsonPath jp = response.jsonPath() ;

        JsonPath jp = get("/spartans").jsonPath() ;

        // print first id in the json array response
       // [{},{},{} ]
        System.out.println("jp.getInt(\"id[0]\") = "
                + jp.getInt("id[0]"));
        // print second json object name in the json array response
        System.out.println("jp.getString(\"name[1]\") = "
                + jp.getString("name[1]"));


    }







}
