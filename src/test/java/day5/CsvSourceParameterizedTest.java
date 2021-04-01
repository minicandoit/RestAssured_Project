package day5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CsvSourceParameterizedTest {

// Test first number + second number = third number
//            1, 3 , 4
//            2, 3 , 5
//            8, 7 , 15
//            10, 9 , 19

    @ParameterizedTest
    @CsvSource({
                "1, 3 , 4",
                "2, 3 , 5",
                "8, 7 , 150",
                "10, 9 , 19"
                })
    public void testAddition(int num1 , int num2 , int expectedResult ){

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println("expectedResult = " + expectedResult);
        assertThat(num1+ num2 , equalTo(expectedResult) ) ;

    }









}
