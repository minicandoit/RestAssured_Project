package day8;

import org.junit.jupiter.api.Test;
import test_util.ConfigurationReader;
import test_util.DB_Utility;
import test_util.SpartanNoAuthBaseTest;

public class SpartanAPI_DB_Test extends SpartanNoAuthBaseTest {


    @Test
    public void testDB_Connection(){

        // this will create HR connection according to your properties file
//        DB_Utility.createConnection();
        String url = ConfigurationReader.getProperty("spartan.database.url");
        String username = ConfigurationReader.getProperty("spartan.database.username");
        String password = ConfigurationReader.getProperty("spartan.database.password");
        DB_Utility.createConnection(url,username,password);


        DB_Utility.destroy();


    }

}
