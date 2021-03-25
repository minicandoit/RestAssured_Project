package day1;

import org.junit.jupiter.api.*;
//Test Lifecycle annotations
// @BeforeAll @AfterAll @BeforeEach @AfterEach


@DisplayName("Learning Test Lifecycle Annotations")
public class TestLifecycleAnnotations {


    @Test
    public void test1(){
        System.out.println("Test 1 is running");
    }

    @Test
    public void test2(){
        System.out.println("Test 2 is running");
    }


}
