package day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Junit5_intro {

    @Test
    public void test(){
        System.out.println("Learning JUnit5");

        assertEquals(1,1) ;
        assertEquals(1,2,"Something is wrong !!");

    }

    // add one more test ,
    // to assert your name first character start with letter A
    @Test
    public void testName(){
        String name = "Adnan";
        assertEquals('A' , name.charAt(0) );
//        assertTrue(name.startsWith("A"));
    }
}
