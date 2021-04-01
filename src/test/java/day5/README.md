# NOTE Day 5 

##  Star War API Task 
```
    Interview Questions :
    Send request to  GET https://swapi.dev/api/people/
    Find out average height of all people showed up in the response
```
Starting with just the first page 
```java
@DisplayName("GET average height from GET /people response")
    @Test
    public void testGetAverageHeight(){

        List<Integer> allHeights =  get("/people")
                                    .jsonPath()
                                    .getList("results.height", Integer.class)
                                    ;
        System.out.println("allHeights = " + allHeights);
        // from here it's all java
        int total = 0;
        for (Integer height : allHeights) {
            total+=height;
        }
        int average = total/(allHeights.size());
        System.out.println("average = " + average);


    }
```

Now If we want to expand this for entire 82 results with 9 pages, 

Here the steps : 
* Create an empty Integer empty list
* Send `GET /people` 
    * capture the total count using jsonPath
    * save first page heights into the list

* Loop : from page 2 till last page 
    * get the list of height integer using jsonPath 
    * add this to the big list

```java
    @DisplayName("Get all heights from all the pages and find average")
    @Test
    public void testGetAllPagesAverageHeight(){

        List<Integer> allHeights = new ArrayList<>() ;

        // send initial request , find total count and decide how many pages exists
        JsonPath jp =  get("/people").jsonPath() ;
        int peopleCount =  jp.getInt("count") ;  //82
        // if there is remainder we want to add 1 , if there is not keep it as is
        int pageCount = (peopleCount % 10==0)  ? peopleCount / 10  :  (peopleCount / 10)+1 ;


        List<Integer> firstPageHeights = jp.getList("results.height") ;
        System.out.println("firstPageHeights = " + firstPageHeights);
        allHeights.addAll(firstPageHeights ) ;


        // now it's time to loop and get the rest of the pages
        for (int pageNum = 2; pageNum <= pageCount ; pageNum++) {
            // GET /people?page = yourPageNumberGoesHere

            List<Integer> heightsOnThisPage =   get("/people?page="+pageNum )
                                                    .jsonPath()
                                                    .getList("results.height");
            allHeights.addAll( heightsOnThisPage ) ;
            // just in case you wanted to see each pages height
            System.out.println("heightsOnThisPage = " + heightsOnThisPage);
        }
        // third page has a value unknown and it's somehow got stored since getList get all all
        // jsonPath is backed by groovy language and it's allowing such value here so we will remove it
        allHeights.remove("unknown") ;
        System.out.println("allHeights = " + allHeights);
        System.out.println("allHeights.size() = " + allHeights.size());

    }

```

# JUnit 5 Parameterized Test

Here is [the documentation link for Parameterized Test](https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests)

Few Options to Parameterize the test 
* `ValueSources` 
  
  Provide one data per iteration directly
    ```java
    @ParameterizedTest
    @ValueSource( ints = {1, 2,4,6,7,10} )
    public void testPrintMultipleIteration(  int num   ){
    }
    
  // bytes ,shorts, ints , longs , floats , doubles , strings ..
    ```

* `@CsvSource`
```csv
1, 3 , 4 
2, 3 , 5 
8, 7 , 15 
```



* `@CSVFileSource`
    


