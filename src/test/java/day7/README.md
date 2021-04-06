# NOTE Day 7 

## Serialization

Java Object to Json (or any other type of text|byteStream)
   ```java
       Spartan sp1 = new Spartan("B21" , "Male",123123123) ; 
   ```
   We provided this object in `POST` request body and expect it to be converted to json string as below
```json
{
    "name": "B21",
    "gender": "Male",
    "phone": 123123123
}
```

## De-Serialization 
Json(text | byteStream) to Java
    
```json
    {
        "id": 8001,
        "name": "Karley",
        "gender": "Male",
        "phone": 1616992336
    }
```
We created POJO class that with 4 fields matches exactly as the json fields 

Easy way to create POJO is using [**Project Lombok**](https://projectlombok.org/features/all)
* Added dependency
```xml
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.18</version>
    </dependency>
```
* Make sure the `Lombok` plugin is installed in IntelliJ.

Lombok use series of annotation to remove repetitive boiler-plate codes. 
```java
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SpartanPOJO {

    private int id;
    private String name;
    private String gender;
    private long phone;
}
```

Two ways we tried to save json result as POJO 
* using `Response` object `as(Class Type)` method if no json path is needed to get the json object. 
    ```java
    Response response = given()
                        .pathParam("id", 8001).
                        when()
                        .get("/spartans/{id}") ;

    SpartanPOJO sp = response.as(SpartanPOJO.class) ;
    ```
* using `JsonPath` object `getObject("json path",Class Type)` if json path is needed to get to the json object.
    ```java
    Response response =
            given()
                    .log().uri()
                    .queryParam("nameContains", "a")
                    .queryParam("gender", "Male").
            when()
                    .get("/spartans/search") ; //.prettyPeek() ;

    // response.as will not work here because we need to provide
    // path to get to the json objet we want  content[0]
    JsonPath jp = response.jsonPath() ;
    SpartanPOJO sp = jp.getObject("content[0]", SpartanPOJO.class );
    ```
  or in one shot in method chain
    ```java
    SpartanPOJO sp1 =  given()
                            .log().uri()
                            .queryParam("nameContains", "a")
                            .queryParam("gender", "Male").
                        when()
                            .get("/spartans/search")
                            .jsonPath()
                            .getObject("content[0]", SpartanPOJO.class );
    ```

  We can also use `getList` method of `JsonPath` object to get the json array into `List<POJO>`
    ```java
    List<SpartanPOJO> lst =  given()
                                .queryParam("nameContains", "a")
                                .queryParam("gender","Male")
                            .when()
                                .get("/spartans/search")
                                .jsonPath()
                                .getList("content", SpartanPOJO.class) ;
    ```
  Here is the example with HR ORDS API 
   ```java
    // Save all countries as List<POJO>
    List<Country> allCountries = get("/countries").jsonPath()
                                .getList("items", Country.class) ;
   ```
  Here is the [full practice examples](HR_ORDS_API_DeserializationTest.java)











