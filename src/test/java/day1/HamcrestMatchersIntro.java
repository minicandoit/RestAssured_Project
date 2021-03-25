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
        // All matchers has 2 overloaded version
        // first that accept actual value
        // second that accept another matchers
        // below examples is method is accepting another matchers equalTo to make it readable
        assertThat(5+5 , is( equalTo(10) ) );

        // negative assertion  5+5 is not 11
        assertThat(5+5, not(11) );
        assertThat(5+5, is( not(11) )   );
        assertThat(5+5, is( not(  equalTo(11)  ) )    );



    }

}
