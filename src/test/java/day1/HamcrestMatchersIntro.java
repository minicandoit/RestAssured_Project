package day1;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersIntro {


    @Test
    public void simpleTest1(){

        // assert 10  equal to 5+5
        // this is the syntax for hamcrest way of assertion
        // assertThat( some actual value , some matcher that describe what you are trying to do)
        assertThat(5+5, is(10) ) ;
        assertThat(5+5, equalTo(10) );


    }

}
