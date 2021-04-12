package day10;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test_util.SpartanWithAuthBaseTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class XML_ResponseTest extends SpartanWithAuthBaseTest {


     @DisplayName("Test GET /spartans xml response")
     @Test
     public void testXML(){
         // provide credentials and provide accept header as xml and send request
         // assert status code 200
         // assert content type is xml
         // assert first data name is Meade
         given()
                 .auth().basic("user","user")
                 .accept( ContentType.XML ).
         when()
                 .get("/spartans").
         then()
                 .log().all()
                 .statusCode(200)
                 .contentType(ContentType.XML)
                 .body("List.item[0].name" , is("Meade") )
                 .body("List.item[0].id" , is("1") )


         ;

     }
     /* response we got (just displayed two for short example)
     <List>
          <item>
            <id>1</id>
            <name>Meade</name>
            <gender>Male</gender>
            <phone>9994128232</phone>
          </item>
          <item>
            <id>2</id>
            <name>Nels</name>
            <gender>Male</gender>
            <phone>4218971348</phone>
          </item>
    </List>
      */



}
